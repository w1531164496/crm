package crm.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import com.google.gson.Gson;

import crm.model.Employee;
import crm.model.ImageData;


/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {


		ImageData img=new ImageData();
		
		//�����������Ӧ�ı����ʽ
       
        request.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        
        //����Api
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        
        //�ж��Ƿ���muitipart/form-data����
        if(!ServletFileUpload.isMultipartContent(request)) {
            resp.getWriter().println("����enctype���Բ���multipart/form-data����");
        }
        
        //���õ����ļ��ϴ���С 2M
        fileUpload.setFileSizeMax(20*1024*1024); 
        //�������ϴ��ļ���С(��ʱ��һ�����ϴ�����ļ�����Ҫ��һ������,�˴�Ϊ10M)
        fileUpload.setSizeMax(10*1024*1024);
        //�����ϴ�������[����Ϊ�Զ���ļ�����]
        //fileUpload.setProgressListener(new ListenerUploadProgress());
        //��������
        try {
        	List<FileItem> parseRequest = (List<FileItem>)fileUpload.parseRequest(new ServletRequestContext(request));
            System.out.println(parseRequest.size());
        	
        	
        	//��ȡ����
            for (FileItem fileItem : parseRequest) {
                //�ж����������ǲ�����ͨ��form���ֶ�
                if(!fileItem.isFormField()) {
                    //�ϴ��ļ�
                    String fileName = fileItem.getName();
                    InputStream fileStream = fileItem.getInputStream();
                    //���屣��ĸ�·��
                    String parentDir = this.getServletContext().getRealPath("/static/upload");
                    //ʹ��UUID+�ļ����ķ�ʽ�������ļ�����
                    String realFileName = UUID.randomUUID().toString()+"-"+fileName;
                    img.setSrc("/crm/static/upload/"+realFileName);
                    img.setTitle("ͼƬ");
                    //����Ҫ������ļ�
                    File file = new File(parentDir,realFileName);
                    //�ж��ļ����Ƿ����
                    if(!file.getParentFile().exists()) {
                        //�����ļ���[�༶�ļ���]file.madir�Ǵ�����һ�ļ���
                        file.getParentFile().mkdirs();
                    }
                    
                    //���������
                    OutputStream out = new FileOutputStream(file);
                    //�����ֽڻ���
                    byte[] buffer = new byte[1024];
                    int len = -1;
                    //һ�ζ�ȡ1kb(1024byte),����-1������ȡ���
                    while((len = fileStream.read(buffer))!=-1) {
                        //һ��д��1kb(1024byte)
                        out.write(buffer,0, len);
                    }
                    
                    //��ˢ����Դ
                    out.flush();
                    //�ر���
                    out.close();
                    fileStream.close();
                    
                }else {
                    //��ͨ�ֶ�
                    
                    //�ֶ���
                    String fieldName = fileItem.getFieldName();
                    //�ֶ�ֵ
                    String fieldValue = fileItem.getString();
                    System.out.println(fieldName+":"+fieldValue);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }        

		
        Map<String, Object> map=new HashMap();
        
        
        
		map.put("code",0);
		map.put("msg", "�ϴ����");		
		map.put("data",img);
		Gson kson=new Gson();
		String wsx=kson.toJson(map);
		PrintWriter ccs=resp.getWriter();	
		
		ccs.write(wsx);
		
//		
//		layui.code
//		{
//		  "code": 0 //0��ʾ�ɹ�������ʧ��
//		  ,"msg": "" //��ʾ��Ϣ //һ���ϴ�ʧ�ܺ󷵻�
//		  ,"data": {
//		    "src": "ͼƬ·��"
//		    ,"title": "ͼƬ����" //��ѡ
//		  }
//		}
//		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
