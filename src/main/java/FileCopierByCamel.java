public class FileCopierByCamel {
	pablic static void main(String[] args) {
		CamelContext context = new DefaultCamelContext();
		try {
			context.addRoutes(new RouterBuilder() {
				@Override
				public void configure() throws Exception {
					from("file:data/inbox?noop=true")
						.to("file:data/outbox");
				}
			});
			context.start();
			Thread.sleep(10000);
			context.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}