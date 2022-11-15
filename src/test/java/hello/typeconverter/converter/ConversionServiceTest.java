package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

public class ConversionServiceTest {

	// ConversionSerive에 converter들을 다 등록해두면 알아서 알맞는 converter가 사용된다.

	@Test
	void conversionTest() {
		// 등록 -> 이 때는 converter들에 다 알아야한다.
		DefaultConversionService conversionService = new DefaultConversionService(); // converter interface를 구현한 구현체.
		conversionService.addConverter(new StringToIntegerConverter());
		conversionService.addConverter(new IntegerToStringConverter());
		conversionService.addConverter(new IpPortToStringConverter());
		conversionService.addConverter(new StringToIpPortConverter());

		// 사용 -> 어떤 converter가 있는지 몰라도 된다.
		Assertions.assertThat(conversionService.convert("10", Integer.class)).isEqualTo(10);
		Assertions.assertThat(conversionService.convert(10, String.class)).isEqualTo("10");
		Assertions.assertThat(conversionService.convert("127.0.0.1:8080", IpPort.class)).isEqualTo(new IpPort("127.0.0.1", 8080));
		Assertions.assertThat(conversionService.convert(new IpPort("127.0.0.1", 8080), String.class)).isEqualTo("127.0.0.1:8080");
	}

}
