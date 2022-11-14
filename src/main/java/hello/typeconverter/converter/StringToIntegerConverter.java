package hello.typeconverter.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class StringToIntegerConverter implements Converter<String, Integer> { // import시, SpringFrameWork꺼로 받는다.

	@Override
	public Integer convert(final String source) {
		log.info("convert source = {}", source);
		return Integer.valueOf(source);
	}
}
