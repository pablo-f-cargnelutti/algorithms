package katas.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FileReader {
	
	private final Path file;

	public FileReader(final String path) throws IOException {
		this.file = Paths.get(path);
	}

	public static FileReader forPath(final String path) throws IOException {
		assertNotNullOrEmpty(path);
		return new FileReader(path);
	}

	private static void assertNotNullOrEmpty(final String value) {
		assertNotNullOrEmpty(value, null);
	}

	private static void assertNotNullOrEmpty(final String value, String message) {
		message = message != null ? message : "Value cannot be null";
		if (value == null || value.isEmpty())
			throw new IllegalArgumentException(message);
	}

	public List<String> readBySeparator(final Separator separator) throws FileReadingException {
		final List<String> allLines = new LinkedList<>();
		
		try(BufferedReader reader = Files.newBufferedReader(this.file, Charset.defaultCharset())) {
			String aLine = null;			
			while( (aLine = reader.readLine()) != null ) {
				allLines.add(aLine);
			}
		}catch(final IOException exception){
			throw new FileReadingException(exception);
		}
		return separator.apply(allLines);
	}

	public enum Separator
	{		
		SPACE(" "),
		UNDERSCORE("_"),
		NONE(),
		LINE_BREAK() {
			@Override
			public List<String> apply(final List<String> allLines) {
				return allLines;
			}
		};
		
		public List<String> apply(final List<String> allLines) {
			final StringBuilder text = new StringBuilder();
			for(final String line : allLines) {
				text.append(line);
			}
			
			return Arrays.asList(text.toString().split(value));
		}
		
		public static Separator newFrom(final String value){
			NONE.value = value;
			return NONE;
		}
		
		Separator(){};
		Separator(final String value) {
			this.value = value;
		}
		private String value;
	}
}
