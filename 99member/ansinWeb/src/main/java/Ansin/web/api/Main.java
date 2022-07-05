//package Ansin.web.api;
//
//import com.alipay.api.AlipayClient;
//import com.alipay.api.CertAlipayRequest;
//import com.alipay.api.DefaultAlipayClient;
//import com.alipay.api.domain.AlipayOpenOperationOpenbizmockBizQueryModel;
//import com.alipay.api.request.AlipayOpenOperationOpenbizmockBizQueryRequest;
//import com.alipay.api.response.AlipayOpenOperationOpenbizmockBizQueryResponse;
//
//public class Main {
//    public static void main(String[] args) {
//        try {
//            // 1. 创建AlipayClient实例
//            AlipayClient alipayClient = new DefaultAlipayClient(getClientParams());
//            // 2. 创建使用的Open API对应的Request请求对象
//            AlipayOpenOperationOpenbizmockBizQueryRequest request = getRequest();
//            // 3. 发起请求并处理响应
//            AlipayOpenOperationOpenbizmockBizQueryResponse response = alipayClient.certificateExecute(request);
//            if (response.isSuccess()) {
//                System.out.println("调用成功。");
//            } else {
//                System.out.println("调用失败，原因：" + response.getMsg() + "，" + response.getSubMsg());
//            }
//        } catch (Exception e) {
//            System.out.println("调用遭遇异常，原因：" + e.getMessage());
//            throw new RuntimeException(e.getMessage(), e);
//        }
//    }
//
//    private static CertAlipayRequest getClientParams() {
//        CertAlipayRequest certParams = new CertAlipayRequest();
//        certParams.setServerUrl("https://openapi.alipay.com/gateway.do");
//        //请更换为您的AppId
//        certParams.setAppId("2019091767145019");
//        //请更换为您的PKCS8格式的应用私钥
//        certParams.setPrivateKey("MIIEvQIBADANB ... ...");
//        //请更换为您使用的字符集编码，推荐采用utf-8
//        certParams.setCharset("utf-8");
//        certParams.setFormat("json");
//        certParams.setSignType("RSA2");
//        //请更换为您的应用公钥证书文件路径
//        certParams.setCertPath("/home/foo/appCertPublicKey_2019091767145019.crt");
//        //请更换您的支付宝公钥证书文件路径
//        certParams.setAlipayPublicCertPath("/home/foo/alipayCertPublicKey_RSA2.crt");
//        //更换为支付宝根证书文件路径
//        certParams.setRootCertPath("/home/foo/alipayRootCert.crt");
//        return certParams;
//    }
//
//    private static AlipayOpenOperationOpenbizmockBizQueryRequest getRequest() {
//        // 初始化Request，并填充Model属性。实际调用时请替换为您想要使用的API对应的Request对象。
//        AlipayOpenOperationOpenbizmockBizQueryRequest request = new AlipayOpenOperationOpenbizmockBizQueryRequest();
//        AlipayOpenOperationOpenbizmockBizQueryModel model = new AlipayOpenOperationOpenbizmockBizQueryModel();
//        model.setBizNo("test");
//        request.setBizModel(model);
//        return request;
//    }
//}