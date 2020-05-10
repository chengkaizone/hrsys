import com.alibaba.fastjson.JSON;
import com.smile.hrsys.HrsysApplication;
import com.smile.hrsys.test.Book;
import com.smile.hrsys.test.TestController;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HrsysApplication.class) // 测试应用上下文
//@WebMvcTest(TestController.class) // 测试单个controller
public class AppTest {

    @Autowired
    WebApplicationContext wac; // 用于模拟web环境

    MockMvc mockMvc;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test // 普通测试方法
    public void contextLoads() {

    }

    @Test
    public void testGet() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/hello/gan")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("testGet >>> " + result);
    }

    @Test
    public void testPost() throws Exception {
        Book book = new Book();
        book.setId(5);
        book.setName("三国演义");
        book.setAuthor("罗贯中");
        String json = JSON.toJSONString(book);
        System.out.println("post json ---> " + json);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/addbook")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("testPost >>> " + result);
    }

    @Test
    public void testPut() throws Exception {
        Book book = new Book();
        book.setId(5);
        book.setName("三国演义");
        book.setAuthor("罗贯中");
        String json = JSON.toJSONString(book);
        System.out.println("put json ---> " + json);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/putbook")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("testPut >>> " + result);
    }

    @Test
    public void testDel() throws Exception {
        Book book = new Book();
        book.setId(5);
        book.setName("三国演义");
        book.setAuthor("罗贯中");
        String json = JSON.toJSONString(book);
        System.out.println("del json ---> " + json);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/delbook/5")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("testDel >>> " + result);
    }

}
