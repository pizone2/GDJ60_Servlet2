package com.iu.home.member;

import java.util.List;

public class ProductService {
	private ProductDAO productDAO;
	
	//1���յ��� ���� (���ϴ�)
//	private ProductDAO productDAO = new ProductDAO();
	//2.�ʱ�ȭ��,���յ��� ���� (���ϴ�)
//	{
//		this.productDAO = new ProductDAO();
//	}
	//3.������,���յ��� ���� (���ϴ�)
	public ProductService() {
		this.productDAO = new ProductDAO();
	}
	//4.ȣ���ؼ� ����ؾ���,setter,���յ� ����,�ּҰ��� �����ϱ� ������ productDAO�� �����Ͽ��� DAO�� �������.
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	
	public int setAddProduct(ProductDTO productDTO,List<ProductOptinDTO> ar)throws Exception{
		//product , option
		Long productNum = productDAO.getProductNum();
		productDTO.setProductNum(productNum);
		int result = productDAO.setAddProduct(productDTO);
		
		for(ProductOptinDTO productOptionDTO:ar) {
			productOptionDTO.setProductNum(productNum);
			result = productDAO.setAddProductOption(null);
		}
		return result;
	}
	

	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAO();
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductName("product1");
		productDTO.setProductDetail("detail1");
		
		ProductOptinDTO productOptinDTO = new ProductOptinDTO();
		productOptinDTO.setOptionName("optionName1");
		productOptinDTO.setOptionPrice(100L);
		productOptinDTO.setOptionAmount(10L);
		productOptinDTO.setProductNum(null);
		
		ProductOptinDTO productOptinDTO2 = new ProductOptinDTO();
		productOptinDTO2.setOptionName("optionName2");
		productOptinDTO2.setOptionPrice(200L);
		productOptinDTO2.setOptionAmount(20L);
		productOptinDTO2.setProductNum(null);
		
		try {
			Long num = productDAO.getProductNum();
			
			productDTO.setProductNum(num);
			
			int result = productDAO.setAddProduct(productDTO);
			
			productOptinDTO.setProductNum(num);
			
			if(result>0) {
				productDAO.setAddProductOption(productOptinDTO);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
	
	
	