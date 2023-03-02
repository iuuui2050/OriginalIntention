package com.iuuui.util.sort;

import com.iuuui.exception.BusinessException;
import com.iuuui.util.sort.common.SortDTO;
import com.iuuui.util.sort.common.SortMapperDTO;

/**
 * @author iuuui
 * @since 2023/02/17 0900
 */
public class SortUtil {


    public static SortMapperDTO sort(SortDTO dto){
        if (dto == null) throw new BusinessException("sort no params");
        int oldSort = dto.getOldSort();
        int newSort = dto.getNewSort();

        SortMapperDTO mapperDTO = new SortMapperDTO();
        int num = 1;
        // up to down
        if (newSort > oldSort){
            num = -1;
            int temp = newSort;
            newSort = oldSort;
            oldSort = temp;
        }
        mapperDTO.setStartNum(newSort);
        mapperDTO.setEndNum(oldSort);
        mapperDTO.setNum(num);
        return mapperDTO;
    }




}
