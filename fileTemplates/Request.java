#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

import com.beetalklib.network.tcp.TCPPacket;
import com.shopee.app.network.ShopeeOpCode;
import com.shopee.app.network.request.NetworkRequest;
#parse("File Header.java")

public class ${NAME}Request extends NetworkRequest{
  public void start(${PARAMETER}) {
        start();
    }
    @Override
    protected TCPPacket getNetworkPacket() {
        ${NAME}.Builder builder = new ${NAME}.Builder();
        builder.requestid(getId().asString());
        return new TCPPacket(ShopeeOpCode.Command.${CMD}, builder.build().toByteArray());
    }
}
