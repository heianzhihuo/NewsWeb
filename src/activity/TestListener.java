package activity;

import java.util.Timer;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TestListener implements ServletContextListener {
	private Timer timer = null;

	public void contextInitialized(ServletContextEvent event) {
		timer = new Timer(true);
		//timer.schedule(new TestTimer(), 0, 1800000);
		// 服务器启动时自动执行，每隔1800000ms执行一次，即每30min执行一次
	}

	public void contextDestroyed(ServletContextEvent event) {
		timer.cancel();// 服务器停止时结束执行
	}
}
