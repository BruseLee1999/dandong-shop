package com.lee;

import com.lee.mapper.CartMapper;
import com.lee.service.AddressService;
import com.lee.util.CodecUtil;
import com.lee.vo.CartVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.lee.util.CodecUtil.getOrderCode;


@SpringBootTest
public class DandongFoodApplicationTests{
    @Autowired
    CartMapper cartMapper;



        @Test
        public int[] plusOne() {
            int[] digits = new int[]{8,9,9,9};
            int length = digits.length;
            if(length == 0)
                return digits;
            else{
                if(digits[length-1] != 9){
                    digits[length-1] = digits[length-1] + 1;
                    return digits;
                }
                else{
                    int[] list = new int[length+1];
                    if(length == 1){
                        list[0] = 1;
                        list[1] = 0;
                    }
                    else{
                        for(int i = length-1; i>0;i--){
                            digits[i] = 0;
                            if(digits[i-1] != 9){
                                digits[i-1] = digits[i-1] +1;
                                break;
                            }
                            else if(digits[i-1] == 9 && i == 1){
                                digits[0] = 0;
                                for(int j = 0; j< length+1; j++){
                                    if(j == 0){
                                        list[j] = 1;
                                    }
                                    else{
                                        list[j] = digits[j-1];
                                    }
                                }
                            }
                        }
                    }
                    return list;
                }
            }
        }
}
