package util;

/**
 * very much optional
 * unfinished
 * @author cidit
 *
 */
public class JsonBuilder {

	private static final char BEGIN_OBJECT = '{', END_OBJECT = '}', BEGIN_ARRAY = '[', END_ARRAY = ']',
			AFFECTATOR = ':', SEPARATOR = ',';

	private String json = "";

	private boolean isObjectOpen = false, isArrayOpen = false;

	public JsonBuilder() {
		json += BEGIN_OBJECT;
	}
	
	
	
	public static String quoteThis(Object o) {
		return "\"" + o + "\"";
	}
}
