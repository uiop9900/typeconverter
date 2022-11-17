package hello.typeconverter.formatter;

import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.format.support.DefaultFormattingConversionService;

public class FormattingConversionServiceTest {

	@Test
	void formattingConversionService() {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(); // 부모에 CconversionService와 Formatter가 둘 다 있음
		//컨버터 등록
		conversionService.addConverter(new StringToIpPortConverter());
		conversionService.addConverter(new IpPortToStringConverter());
		//포멧터 등록
		conversionService.addFormatter(new MyNumberFormatter());

		// 컨버터 사용
		IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
		Assertions.assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));
		// 포멧터 사용
		Assertions.assertThat(conversionService.convert(1000, String.class)).isEqualTo("1,000");
		Assertions.assertThat(conversionService.convert("1000", Long.class)).isEqualTo(1000L); // 자동으로 제공하는 convert 메소드를 사용하면 된다.
	}
}
