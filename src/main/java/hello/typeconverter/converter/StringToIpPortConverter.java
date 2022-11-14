package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class StringToIpPortConverter implements Converter<String, IpPort> {

	@Override
	public IpPort convert(final String source) {
		log.info("conver source={}", source);
		// "127.0.0.1:8080"
		final String[] split = source.split(":");
		final String ip = split[0];
		final int port = Integer.parseInt(split[1]);
		return new IpPort(ip, port);
	}
}
