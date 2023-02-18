package com.epam.springshop.utils;

import com.epam.springshop.dto.UserDto;
import com.epam.springshop.model.*;
import com.epam.springshop.model.enums.RoleEnum;
import com.epam.springshop.model.enums.StatusEnum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class TestUtils {
    // user
    public static long USER_ID = 1L;
    public static String USER_LOGIN = "login";
    public static String USER_NAME = "name";
    public static String USER_SURNAME = "surname";
    public static String USER_PHONE_NUMBER = "0734928817";
    public static String USER_EMAIL = "email@epam.com";
    public static String USER_LOCALE = "UK";
    public static RoleEnum USER_ROLE = RoleEnum.USER;
    public static boolean USER_ENABLED = true;
    public static String USER_PASSWORD = "password";
    // userDto
    public static long USER_DTO_ID = 1L;
    public static String USER_DTO_LOGIN = "login";
    public static String USER_DTO_NAME = "name";
    public static String USER_DTO_SURNAME = "surname";
    public static String USER_DTO_PHONE_NUMBER = "0734928817";
    public static String USER_DTO_EMAIL = "email@epam.com";
    public static String USER_DTO_LOCALE = "UK";
    public static String USER_DTO_ROLE = RoleEnum.USER.toString();
    public static String USER_DTO_PASSWORD = "password";
    // product
    public static long PRODUCT_ID = 1L;
    public static String PRODUCT_TITLE = "title";
    public static String PRODUCT_DESCRIPTION = "description";
    public static Double PRODUCT_PRICE = 10.10;
    public static String PRODUCT_IMAGE_URL = "image.jpg";
    public static Date PRODUCT_POST_DATE;
    public static Integer Product_IN_STOCK = 3;
    public static Category PRODUCT_CATEGORY = getCategory();

    static {
        try {
            PRODUCT_POST_DATE = new SimpleDateFormat("yyyy/MM/dd").parse("2020/10/10");
        } catch (ParseException e) {
            throw new RuntimeException("Can't parse PRODUCT_DATE in TestUtils");
        }
    }

    // Order
    public static long ORDER_ID = 1L;
    public static StatusEnum ORDER_STATUS = StatusEnum.CREATED;
    public static Date ORDER_ORDER_DATE;

    static {
        try {
            ORDER_ORDER_DATE = new SimpleDateFormat("yyyy/MM/dd").parse("2020/10/10");
        } catch (ParseException e) {
            throw new RuntimeException("Can't parse ORDER_DATE in TestUtils");
        }
    }

    // OrderItem
    public static long ORDER_ITEM_ID = 1L;
    public static int ORDER_ITEM_QUANTITY = 2;

    // Category
    public static long CATEGORY_ID = 1L;
    public static String CATEGORY_CATEGORY = "category_name";

    public static User getUser() {
        return new User(USER_ID, USER_LOGIN, USER_NAME,
                USER_SURNAME,
                USER_PHONE_NUMBER,
                USER_EMAIL,
                USER_LOCALE,
                USER_ROLE,
                USER_ENABLED,
                USER_PASSWORD,
                List.of());
    }

    public static UserDto getUserDto() {
        return new UserDto(USER_DTO_ID,
                USER_DTO_LOGIN,
                USER_DTO_NAME,
                USER_DTO_SURNAME,
                USER_DTO_PHONE_NUMBER,
                USER_DTO_EMAIL,
                USER_DTO_LOCALE,
                USER_DTO_PASSWORD,
                USER_DTO_ROLE);
    }

    public static Order getOrder() {
        return new Order(ORDER_ID,
                ORDER_STATUS,
                ORDER_ORDER_DATE,
                getUser(),
                Set.of()
        );
    }

    public static OrderItem getOrderItem() {
        return new OrderItem(ORDER_ITEM_ID,
                null,
                getProduct(),
                ORDER_ITEM_QUANTITY
        );
    }

    public static Product getProduct() {
        return new Product(PRODUCT_ID,
                PRODUCT_TITLE,
                PRODUCT_DESCRIPTION,
                PRODUCT_PRICE,
                PRODUCT_IMAGE_URL,
                PRODUCT_POST_DATE,
                Product_IN_STOCK,
                PRODUCT_CATEGORY,
                List.of());
    }

    public static Category getCategory() {
        return new Category(CATEGORY_ID,
                CATEGORY_CATEGORY,
                List.of());
    }
}
