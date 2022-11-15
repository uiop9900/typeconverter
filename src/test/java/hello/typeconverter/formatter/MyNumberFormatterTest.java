package hello.typeconverter.formatter;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.Locale;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MyNumberFormatterTest {

	MyNumberFormatter formatter = new MyNumberFormatter();
	@Test
	void parse() throws ParseException {
		final Number result = formatter.parse("1,000", Locale.KOREA);
		Assertions.assertThat(result).isEqualTo(1000L); // long 타입
	}

	@Test
	void print() {
		final String result = formatter.print(1000, Locale.KOREA);
		Assertions.assertThat(result).isEqualTo("1,000");
	}
}