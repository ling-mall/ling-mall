package com.ling.lingcloud.common.util.ip;

import java.io.File;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.ObjectUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lionsoul.ip2region.xdb.Searcher;

/**
 * 根据 ip 地址定位工具类，离线方式.
 * 参考地址：<a href="https://gitee.com/lionsoul/ip2region/tree/master/binding/java">集成 ip2region 实现离线 IP 地址定位库</a>
 * 来源： <a href="https://gitee.com/dromara/RuoYi-Vue-Plus">...</a>
 * Class created on 2023/7/17 by 钟舒艺
 *
 * @author lishuyan
 */
@Slf4j
@SuppressWarnings("unused")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IpSearcher {

    private static final String FILE_NAME = "/ip2region.xdb";

    private static Searcher searcher = null;

    static {
        File existFile = FileUtil.file(FileUtil.getTmpDir() + FileUtil.FILE_SEPARATOR + FILE_NAME);
        if (!FileUtil.exist(existFile)) {
            ClassPathResource fileStream = new ClassPathResource(FILE_NAME);
            if (ObjectUtil.isEmpty(fileStream.getStream())) {
                log.error("RegionUtils 初始化失败，原因：IP 地址库数据不存在！");
            }
            FileUtil.writeFromStream(fileStream.getStream(), existFile);
        }

        String dbPath = existFile.getPath();

        // 1、从 dbPath 加载整个 xdb 到内存。
        byte[] allBuff = new byte[0];
        try {
            allBuff = Searcher.loadContentFromFile(dbPath);
        } catch (Exception e) {
            log.error("RegionUtils 初始化失败，原因：从 ip2region.xdb 文件加载内容失败！" + e.getMessage());
        }
        // 2、使用上述的 cBuff 创建一个完全基于内存的查询对象。
        try {
            searcher = Searcher.newWithBuffer(allBuff);
        } catch (Exception e) {
            log.error("RegionUtils 初始化失败，原因：" + e.getMessage());
        }
    }

    /**
     * 根据 IP 地址离线获取城市.
     */
    public static String getCityInfo(String ip) {
        try {
            ip = ip.trim();
            // 3、执行查询
            String region = searcher.search(ip);
            return region.replace("0|", "").replace("|0", "");
        } catch (Exception e) {
            log.error("IP 地址离线获取城市异常 {}", ip);
            return "未知";
        }
    }
}