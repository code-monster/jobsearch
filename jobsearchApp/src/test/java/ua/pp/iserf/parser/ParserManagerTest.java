package ua.pp.iserf.parser;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import ua.pp.iserf.config.DBUnitConfig;
import ua.pp.iserf.parser.core.Module;

/**
 *
 * @author alex
 */
@WebAppConfiguration
public class ParserManagerTest extends DBUnitConfig {

    @Autowired
    ParserManager parserManager;

    public ParserManagerTest() throws SQLException, ClassNotFoundException {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testRetrieveModuleInfo() {

        //given
        List<Module> moduleList = parserManager.getModuleList();

        List expectResult = new ArrayList();
        for (Module module : moduleList) {
            module.setEnable(false);
            expectResult.add(module.getName() + " enabled:false");
        }
        //when
        List retrieveModuleInfo = parserManager.retrieveModuleInfo();

        //then
        Assert.assertEquals(expectResult, retrieveModuleInfo);

    }

}
