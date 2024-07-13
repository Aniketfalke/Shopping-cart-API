package com.mindtree.utils;

public interface ExceptionConstants {
    public  String PRODUCT_MISSING ="Requested product does not exist";


    public  String CART_MISSING ="User not associated to cart or cart not present ";


    public  String CARTITEM_MISSING ="Requested cart does not exist.please add it ot the cart before updation";


    public  String CART_ID_INVALID_GET_REQUEST="Please enter a valid cart Id to fetch the item";


    public  String CART_ITEM_MISSING_IN_REQUEST ="Please provide valid Cart id fetch the cart Item";


    public  String CART_MISSING_IN_CART_ITEM_REQUEST ="Please provide a valid cart Id to add item";


    public  String PRODUCT_MISSING_IN_CART_ITEM_REQUEST ="Please provide valid Product Id to add the cart";


    public  String CART_ID_INVALID_DELETE_REQUEST ="Please enter a valid cartItemId to delete";


    public  String PRODUCT_ID_INVALID_DELETE_REQUEST ="Please enter a valid productId to delete";


    public  String INVALID_PRODUCT_ID_IN_REQUEST ="Please enter valid Product Id to fetch product";


    public  String INVALID_PRODUCT_NAME_IN_REQUEST ="Plase enter valid Product Name to fetch product";


    public  String  INVALID_CATEGORY_NAME_IN_REQUEST ="Plase enter valid Product Category to fetch product";


}
