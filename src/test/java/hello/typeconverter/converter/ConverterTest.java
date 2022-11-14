package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConverterTest {

	@Test
	void StringToInteger() {
		final StringToIntegerConverter converter = new StringToIntegerConverter(); // 아까 구현한 객체 생성
		final Integer result = converter.convert("10");
		Assertions.assertThat(result).isEqualTo(10);
	}

	@Test
	void IntegerToString() {
		final IntegerToStringConverter converter = new IntegerToStringConverter();
		final String result = converter.convert(10);
		Assertions.assertThat(result).isEqualTo(result);
	}

	@Test
	void StringToIpPort() {
		final IpPortToStringConverter converter = new IpPortToStringConverter();
		final IpPort ipPort = new IpPort("127.0.0.1", 8080);
		final String result = converter.convert(ipPort);
		Assertions.assertThat(result).isEqualTo("127.0.0.1:8080");
	}

	@Test
	void IpPortToString() {
		final StringToIpPortConverter converter = new StringToIpPortConverter();
		String source = "127.0.0.1:8080";
		final IpPort result = converter.convert(source);
		Assertions.assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080));
	}
}
