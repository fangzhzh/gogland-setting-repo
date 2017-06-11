#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
import com.shopee.app.domain.data.DataMapper;
import com.shopee.app.domain.event.EVENT;
import com.shopee.app.network.NetworkRegister;
import com.shopee.app.network.ShopeeOpCode;
import com.shopee.app.network.processors.BaseProcessor;

import java.io.IOException;

#parse("File Header.java")

// TODO don't forget add ${NAME}Processor to NetworkRegister
public class ${NAME}Processor extends BaseProcessor {

    @Override
    public void onProcess(byte[] bytes, int len) throws IOException {
        ${RESPONSE} response = NetworkRegister.WIRE.parseFrom(bytes, 0, len, ${RESPONSE}.class);
        if (!isValid(response)) {
            return;
        }
    }

    private boolean isValid(${RESPONSE} response) {
        return (response.errcode == ShopeeOpCode.Errcode.OK);
    }

    @Override
    public int getCommand() {
        return ShopeeOpCode.Command.${COMMAND};
    }
}
