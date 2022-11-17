package hello.typeconverter;

import hello.typeconverter.converter.IntegerToStringConverter;
import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIntegerConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.formatter.MyNumberFormatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addFormatters(final FormatterRegistry registry) {
		// 둘 다 "String을" 혹은 "String으로" 변환하는 클래스라 이런 경우, converter가 더 우선순위를 갖기때문에 주석처리를 한다.
		//registry.addConverter(new StringToIntegerConverter());
		//registry.addConverter(new IntegerToStringConverter());
		registry.addConverter(new IpPortToStringConverter());
		registry.addConverter(new StringToIpPortConverter());

		// 추가
		registry.addFormatter(new MyNumberFormatter());
	}
}
