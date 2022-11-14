package hello.typeconverter.type;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode // 참조값이 달라고 data가 동일하면 true를 뱉는다.
public class IpPort {
	private String ip;
	private int port;

	public IpPort(final String ip, final int port) {
		this.ip = ip;
		this.port = port;
	}
}
