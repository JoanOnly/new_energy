package {{@servicePackagePath@}};

import {{@mapperPath@}};
import {{@pojoPath@}};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zxkj.energy.config.exception.FailException;
import com.zxkj.energy.enums.ResultEnum;
import java.util.List;

/**
 * {{@serviceTitle@}}
 *
 * @author {{@author@}}
 */
@Service
public class {{@serviceName@}} {
    private {{@mapperName@}} {{@mapperNameMin@}};

    @Autowired
    public {{@serviceName@}}({{@mapperName@}} {{@mapperNameMin@}}) {
        this.{{@mapperNameMin@}} = {{@mapperNameMin@}};
    }

    /**
     * 方法描述：添加记录.
     * 创建时间：{{@date@}}
     * 创建作者：{{@author@}}
     *
     * @param record 记录对象
     */
    public Boolean insert({{@pojoName@}} record) {
        return {{@mapperNameMin@}}.insertSelective(record) == 1;
    }

    /**
     * 方法描述：通过记录id删除记录.
     * 创建时间：{{@date@}}
     * 创建作者：{{@author@}}
     *
     * @param id 记录id
     */
    public Boolean deleteById(Long id) {
        return {{@mapperNameMin@}}.deleteById(id) == 1;
    }

    /**
     * 方法描述：更新记录.
     * 创建时间：{{@date@}}
     * 创建作者：{{@author@}}
     *
     * @param record 记录对象
     */
    public {{@pojoName@}} update({{@pojoName@}} record) {
        if ({{@mapperNameMin@}}.updateByPrimaryKeySelective(record) == 1) {
            return {{@mapperNameMin@}}.selectByPrimaryKey(record.getId());
        }
        throw new FailException(ResultEnum.ERROR_MODIFY);
    }

    /**
     * 方法描述：根据记录id查询记录.
     * 创建时间：{{@date@}}
     * 创建作者：{{@author@}}
     *
     * @param id 记录id
     */
    public {{@pojoName@}} selectById(Long id) {
        return {{@mapperNameMin@}}.selectByPrimaryKey(id);
    }

    /**
     * 方法描述：根据 查询对象 查询出单条记录.
     * 创建时间：{{@date@}}
     * 创建作者：{{@author@}}
     *
     * @param record 查询对象
     */
    public {{@pojoName@}} find({{@pojoName@}} record) {
        return {{@mapperNameMin@}}.find(record);
    }

    /**
     * 方法描述：根据 查询对象 查询出列表记录.
     * 创建时间：{{@date@}}
     * 创建作者：{{@author@}}
     *
     * @param record 查询对象
     */
    public List<{{@pojoName@}}> list({{@pojoName@}} record) {
        return {{@mapperNameMin@}}.list(record);
    }

}
