package TestCase.Vendor;

import ApiTestUtility.ApiBizResponseData;
import ApiTestUtility.ApiRequestData;
import ApiTestUtility.ApiTestHelper;
import com.test.utility.FileOpHelper;
import com.test.utility.RequestType;
import com.test.utility.TestResultType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVendorRecord {

    @Test
    //测试创建新商家
    public void  PsPCreateaNewVendor(){
        //1.获取测试模块名称、测试用例名称
        ApiTestHelper.TestFunctionName = this.getClass().getName();
        ApiTestHelper.TestCaseName = Thread.currentThread() .getStackTrace()[1].getMethodName();
        //2.设置测试数据
        ApiRequestData apirequestdata  = new ApiRequestData();
        //2.1 测试方法
        apirequestdata.SetMethod("Vendor.Record");
        //2.2 接口请求方式
        apirequestdata.SetRequestType(RequestType.Post);
        //2.3 Appid
        apirequestdata.SetAppid("1027");
        //2.4 Appsecret
        apirequestdata.SetAppsecret("admin");
        //2.5 测试业务数据（从文件中读取）
        apirequestdata.SetBizdata(FileOpHelper.Read("\\Vendor\\vendor.record"));
        ApiTestHelper.ApiRequestData=apirequestdata;
        //3.执行接口测试
        ApiBizResponseData responseData = ApiTestHelper.ExcuteApiTset();
        //4.断言测试结果
        try {
            Assert.assertEquals(responseData.GetCode(),"0");
            ApiTestHelper.RecordTestResult(TestResultType.Pass, "测试通过");
        }
        catch (Exception ex)
        {
            ApiTestHelper.RecordTestResult(TestResultType.Failed, "测试未通过"+ ex.getMessage());
        }
    }
}
