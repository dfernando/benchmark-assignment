package com.benchmark.assesment;

import com.benchmark.assesment.controllers.CheapestTripFinderController;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

import javax.xml.bind.annotation.XmlAnyAttribute;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CheapestTripFinderController.class, WebAppContext.class})
@WebAppConfiguration
public class CheapestTripFinderTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(CheapestTripFinderController.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Autowire
    CheapestTripFinderController fixture;

    MockMvc mockMvc

    @Setup
    public void setup(){

    }

    @Test
    public void shouldEstablishProperConnection(){}

    @Test
    public void shouldMakeSureParamsAreValid(){}

    @Test
    public void shouldVerifyPayload(){}

    @Test
    public void shouldReturnCheapestThreeFromPayload(){}

    @Test


}
