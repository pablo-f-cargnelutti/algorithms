package katas.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import katas.src.FileReader;
import katas.src.FileReadingException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FileReaderTest {
	
	@Test
	public void testReadAFileBasedOnSpaceSeparator() throws IOException, FileReadingException
	{
		final FileReader fileReader = FileReader.forPath("./src/Katas/test/multiLine.txt");
		
		final List<String> fileLines = fileReader.readBySeparator(FileReader.Separator.SPACE);
		
		assertEquals(4, fileLines.size());
		assertTrue(fileLines.contains("Hello"));
		assertTrue(fileLines.contains("worldJaja"));
		assertTrue(fileLines.contains("byebye"));
		assertTrue(fileLines.contains("dude"));
	}
	
	@Test
	public void testReadAFileBasedOnUnderscoreSeparator() throws IOException, FileReadingException
	{
		final FileReader fileReader = FileReader.forPath("./src/Katas/test/multiLineSeparatedByUnderscore.txt");
		
		final List<String> fileLines = fileReader.readBySeparator(FileReader.Separator.UNDERSCORE);
		
		assertEquals(2, fileLines.size());
		assertTrue(fileLines.contains("Hello world Jaja"));
		assertTrue(fileLines.contains("byebye dude"));		
	}
	
	@Test
	public void testReadAFileBasedOnLineBreakSeparator() throws IOException, FileReadingException
	{
		final FileReader fileReader = FileReader.forPath("./src/Katas/test/multiLine.txt");
		
		final List<String> fileLines = fileReader.readBySeparator(FileReader.Separator.LINE_BREAK);
		
		assertEquals(2, fileLines.size());
		assertTrue(fileLines.contains("Hello world"));
		assertTrue(fileLines.contains("Jaja byebye dude"));		
	}
	
	@Test
	public void testReadAFileBasedOnCustomSeparator() throws IOException, FileReadingException
	{
		final FileReader fileReader = FileReader.forPath("./src/Katas/test/multiLine.txt");
		
		final List<String> fileLines = fileReader.readBySeparator(FileReader.Separator.newFrom("e"));
		
		assertEquals(4, fileLines.size());
		assertTrue(fileLines.contains("H"));
		assertTrue(fileLines.contains("llo worldJaja by"));
		assertTrue(fileLines.contains("by"));
		assertTrue(fileLines.contains(" dud"));
	}
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void testReadAFileThatNotExistSholdThrowException() throws IOException, FileReadingException
	{
		expectedException.expect(FileReadingException.class);
		
		final FileReader fileReader = FileReader.forPath(".NOT_EXISTING_FILE.txt");
		
		fileReader.readBySeparator(FileReader.Separator.LINE_BREAK);
		
		
	}

}
