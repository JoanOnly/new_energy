package {{@controllerPackagePath@}};

import com.zxkj.energy.system.page.Paging;
import com.zxkj.energy.controller.base.BaseController;
import com.zxkj.energy.enums.ResultEnum;
import com.zxkj.energy.pojo.base.CommonResult;
import com.zxkj.energy.system.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import {{@pojoPath@}};
import {{@servicePackagePath@}}.{{@serviceName@}};

/**
 * {{@controllerTitle@}}
 *
 * @author {{@author@}}
 * @date：{{@date@}}
 */
@RestController
@RequestMapping("/{{@aliasName@}}")
public class {{@controllerName@}} extends BaseController {
    private {{@serviceName@}} {{@serviceNameMin@}};

    @Autowired
    public {{@controllerName@}}({{@serviceName@}} record) {
        this.{{@serviceNameMin@}} = record;
    }

    /**
     * 方法描述：添加
     * 创建时间：{{@date@}}
     * 创建作者：{{@author@}}
     *
     * @param record the record
     * @return the common result
     */
    @PostMapping("/insert")
    public CommonResult insert({{@pojoName@}} record) {
        return resultWrapper({{@serviceNameMin@}}.insert(record), ResultEnum.SUCCESS);
    }

    /**
     * 方法描述：逻辑删除
     * 创建时间：{{@date@}}
     * 创建作者：{{@author@}}
     *
     * @param id the id
     * @return the common result
     */
    @PostMapping("/delete")
    public CommonResult delete(
            @RequestParam(value = "id", required = true) Long id
    ) {
        return resultWrapper({{@serviceNameMin@}}.deleteById(id), ResultEnum.SUCCESS_DELETE);
    }

    /**
     * 方法描述：修改
     * 创建时间：{{@date@}}
     * 创建作者：{{@author@}}
     *
     * @param record the record
     * @return the common result
     */
    @PostMapping("/update")
    public CommonResult update({{@pojoName@}} record) {
        return resultWrapper(ResultEnum.SUCCESS_MODIFY, {{@serviceNameMin@}}.update(record));
    }

    /**
     * 方法描述：根据id查询单条信息
     * 创建时间：{{@date@}}
     * 创建作者：{{@author@}}
     *
     * @param id the id
     * @return the common result
     */
    @PostMapping("/getInfo")
    public CommonResult selectById(
            @RequestParam(value = "id", required = true) Long id
    ) {
        return resultWrapper(ResultEnum.SUCCESS_LOAD, {{@serviceNameMin@}}.selectById(id));
    }

    /**
     * 方法描述：分页
     * 创建时间：{{@date@}}
     * 创建作者：{{@author@}}
     *
     * @param record the record
     * @return the page
     */
    @PostMapping("/getPage")
    @Paging
    public Page<{{@pojoName@}}> page({{@pojoName@}} record) {
        return new Page<>({{@serviceNameMin@}}.list(record));
    }
}

