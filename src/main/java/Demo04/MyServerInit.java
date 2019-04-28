package Demo04;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class MyServerInit extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline channelPipeline= ch.pipeline();


        channelPipeline.addLast(new IdleStateHandler(3,5,7,TimeUnit.SECONDS));
        channelPipeline.addLast(new MyServerHandler());

    }
}
