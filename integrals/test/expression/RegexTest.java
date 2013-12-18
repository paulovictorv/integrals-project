package expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegexTest {
	@Test
	public void testParserDoubleIntegral(){
		String pattern = "int(i?n?t?(i?n?t?(.*?)?d?[x|y|z]?)?d?[x|y|z]?)d[x|y|z]";
		Pattern compile = Pattern.compile(pattern);
		Matcher matcher = compile.matcher("intintx^2+y^2dxdy");
		matcher.find();
		System.out.println(matcher.group(3));
	}
}
