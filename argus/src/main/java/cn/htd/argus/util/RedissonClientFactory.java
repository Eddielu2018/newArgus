package cn.htd.argus.util;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedissonClientFactory {
	private String host;
	private int port;
	private static RedissonClient redissonClient;
	
	public RedissonClient initRedissonClient()
	{
		if (redissonClient == null)
		{
			synchronized (RedissonClientFactory.class) {
				if (redissonClient == null)
				{
					Config config = new Config();
					config.useSingleServer().setAddress(host + ":" + port);
					redissonClient = Redisson.create(config);
				}
			}
		}
		return redissonClient;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
