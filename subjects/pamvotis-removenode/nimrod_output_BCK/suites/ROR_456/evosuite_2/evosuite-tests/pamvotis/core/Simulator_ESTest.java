/*
 * This file was automatically generated by EvoSuite
 * Mon Mar 18 18:46:49 GMT 2019
 */

package pamvotis.core;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import pamvotis.core.MobileNode;
import pamvotis.core.Simulator;
import pamvotis.core.SpecParams;
import pamvotis.sources.Source;
import pamvotis.sources.VideoSource;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Simulator_ESTest extends Simulator_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      assertEquals(0L, simulator0.getTime());
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertNotNull(simulator0);
      
      int int0 = 3390;
      simulator0.addNode(1, 18000000, 18000000, 3390, 1, 1);
      assertEquals(0L, simulator0.getTime());
      assertEquals(Float.NaN, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertEquals(Float.NaN, simulator0.getSysUtil(), 0.01F);
      assertEquals(Float.NaN, simulator0.getSysThrBps(), 0.01F);
      
      try { 
        simulator0.getDelay(12000);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Node 12000 does not exist.
         //
         verifyException("pamvotis.core.Simulator", e);
      }
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0L, simulator0.getTime());
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertNotNull(simulator0);
      
      simulator0.removeAllNodes();
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0L, simulator0.getTime());
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      
      simulator0.addNode(6000000, 1009, (-3870), 798, 6000000, 798);
      assertEquals(Float.NaN, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertEquals(Float.NaN, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0L, simulator0.getTime());
      assertEquals(Float.NaN, simulator0.getSysUtil(), 0.01F);
      
      try { 
        simulator0.removeNode((-1155));
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Node -1155 does not exist.
         //
         verifyException("pamvotis.core.Simulator", e);
      }
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      assertEquals(0L, simulator0.getTime());
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertNotNull(simulator0);
      
      int int0 = 9000000;
      int int1 = 0;
      SpecParams.CW_MIN_OFDM = 0;
      simulator0.addNode(9000000, 9000000, 9000000, 0, 1526, 0);
      assertEquals(0L, simulator0.getTime());
      assertEquals(Float.NaN, simulator0.getSysUtil(), 0.01F);
      assertEquals(Float.NaN, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(Float.NaN, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      
      float float0 = simulator0.getQDelay(9000000);
      assertEquals(0L, simulator0.getTime());
      assertEquals(Float.NaN, simulator0.getSysUtil(), 0.01F);
      assertEquals(Float.NaN, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(Float.NaN, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertEquals(0.0F, float0, 0.01F);
      
      SpecParams.CW_MIN_DSSS = 9000000;
      // Undeclared exception!
      try { 
        simulator0.printHeaders();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("pamvotis.core.Simulator", e);
      }
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertEquals(0L, simulator0.getTime());
      assertEquals(0, simulator0.getProgress());
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertNotNull(simulator0);
      
      simulator0.printMeanValues();
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertEquals(0L, simulator0.getTime());
      assertEquals(0, simulator0.getProgress());
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      
      simulator0.addNode(1516, 1516, 1516, 0, 0, 858);
      assertEquals(Float.NaN, simulator0.getSysUtil(), 0.01F);
      assertEquals(0L, simulator0.getTime());
      assertEquals(0, simulator0.getProgress());
      assertEquals(Float.NaN, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(Float.NaN, simulator0.getSysThrBps(), 0.01F);
      
      simulator0.addNode(0, 0, 0, 0, 0, 0);
      assertEquals(Float.NaN, simulator0.getSysUtil(), 0.01F);
      assertEquals(0L, simulator0.getTime());
      assertEquals(0, simulator0.getProgress());
      assertEquals(Float.NaN, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(Float.NaN, simulator0.getSysThrBps(), 0.01F);
      
      float float0 = simulator0.getThrPkts(0);
      assertEquals(Float.NaN, simulator0.getSysUtil(), 0.01F);
      assertEquals(0L, simulator0.getTime());
      assertEquals(0, simulator0.getProgress());
      assertEquals(Float.NaN, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(Float.NaN, simulator0.getSysThrBps(), 0.01F);
      assertEquals(Float.NaN, float0, 0.01F);
      
      float float1 = simulator0.getMDelay(0);
      assertNotEquals(float1, float0, 0.01F);
      assertEquals(Float.NaN, simulator0.getSysUtil(), 0.01F);
      assertEquals(0L, simulator0.getTime());
      assertEquals(0, simulator0.getProgress());
      assertEquals(Float.NaN, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(Float.NaN, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0.0F, float1, 0.01F);
      
      // Undeclared exception!
      try { 
        simulator0.getQLength(0);
        fail("Expecting exception: ArithmeticException");
      
      } catch(ArithmeticException e) {
         //
         // / by zero
         //
         verifyException("pamvotis.core.Simulator", e);
      }
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      assertEquals(0, simulator0.getProgress());
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0L, simulator0.getTime());
      assertNotNull(simulator0);
      
      simulator0.addNode((-5086), (-5086), 0, (-1043), 498, (-4929));
      assertEquals(0, simulator0.getProgress());
      assertEquals(Float.NaN, simulator0.getSysUtil(), 0.01F);
      assertEquals(Float.NaN, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(Float.NaN, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0L, simulator0.getTime());
      
      simulator0.printMeanValues();
      assertEquals(0, simulator0.getProgress());
      assertEquals(Float.NaN, simulator0.getSysUtil(), 0.01F);
      assertEquals(Float.NaN, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(Float.NaN, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0L, simulator0.getTime());
      
      simulator0.confParams();
      assertEquals(0, simulator0.getProgress());
      assertEquals(Float.NaN, simulator0.getSysUtil(), 0.01F);
      assertEquals(Float.NaN, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(Float.NaN, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0L, simulator0.getTime());
      
      try { 
        simulator0.getThrBps(498);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Node 498 does not exist.
         //
         verifyException("pamvotis.core.Simulator", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0L, simulator0.getTime());
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertNotNull(simulator0);
      
      SpecParams.SHORT_PHY = 5776000.0F;
      // Undeclared exception!
      try { 
        simulator0.printHeaders();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("pamvotis.core.Simulator", e);
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0L, simulator0.getTime());
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertNotNull(simulator0);
      
      int int0 = 1007;
      SpecParams.SIFS_G = 1576.8F;
      VideoSource videoSource0 = new VideoSource(101, 0, 0, 1007, 1007, 1007, 0);
      assertEquals(0L, Source.timer);
      assertEquals(101, videoSource0._sourceId);
      assertEquals(0.0F, Source.slot, 0.01F);
      assertEquals(0, videoSource0.pktLength);
      assertEquals(0, videoSource0.packetToBeTransmittedID);
      assertEquals(0, videoSource0.interArTime);
      assertNotNull(videoSource0);
      
      videoSource0.interArTime = 1007;
      try { 
        simulator0.appendNewSource(1007, videoSource0);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Node 1007 does not exist.
         //
         verifyException("pamvotis.core.Simulator", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      assertEquals(0L, simulator0.getTime());
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertNotNull(simulator0);
      
      MobileNode.timer = 9L;
      int int0 = simulator0.getProgress();
      assertEquals(0L, simulator0.getTime());
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertEquals(0, int0);
      
      float float0 = simulator0.getSysThrBps();
      assertEquals(0L, simulator0.getTime());
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertEquals(0.0F, float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      assertEquals(0L, simulator0.getTime());
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertNotNull(simulator0);
      
      SpecParams.SLOT_NON_ERP = 1510.8525F;
      float float0 = simulator0.getSysUtil();
      assertEquals(0L, simulator0.getTime());
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0.0F, float0, 0.01F);
      
      int int0 = (-1584);
      simulator0.addNode((-1584), (-1584), 0, 0, 0, 98);
      assertEquals(0L, simulator0.getTime());
      assertEquals(Float.NaN, simulator0.getSysThrBps(), 0.01F);
      assertEquals(Float.NaN, simulator0.getSysUtil(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertEquals(Float.NaN, simulator0.getSysThrPkts(), 0.01F);
      
      boolean boolean0 = simulator0.removeNode((-1584));
      assertEquals(0L, simulator0.getTime());
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertTrue(boolean0);
      
      SpecParams.SIFS_G = 648.0F;
      simulator0.removeAllNodes();
      assertEquals(0L, simulator0.getTime());
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      
      try { 
        simulator0.getJitter((-69));
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Node -69 does not exist.
         //
         verifyException("pamvotis.core.Simulator", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      assertEquals(0L, simulator0.getTime());
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertNotNull(simulator0);
      
      int int0 = simulator0.getProgress();
      assertEquals(0L, simulator0.getTime());
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertEquals(0, int0);
      
      simulator0.addNode(1542, 0, 0, 0, 1542, 3466);
      assertEquals(0L, simulator0.getTime());
      assertEquals(Float.NaN, simulator0.getSysUtil(), 0.01F);
      assertEquals(Float.NaN, simulator0.getSysThrBps(), 0.01F);
      assertEquals(Float.NaN, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      
      try { 
        simulator0.removeSource(1542, 0);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Source 0 does not exist.
         //
         verifyException("pamvotis.core.SourceManager", e);
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0L, simulator0.getTime());
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertNotNull(simulator0);
      
      try { 
        simulator0.getRatts(12000);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Node 12000 does not exist.
         //
         verifyException("pamvotis.core.Simulator", e);
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      assertEquals(0L, simulator0.getTime());
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertNotNull(simulator0);
      
      float float0 = simulator0.getSysUtil();
      assertEquals(0L, simulator0.getTime());
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0.0F, float0, 0.01F);
      
      try { 
        simulator0.removeSource(2528, 2528);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Node 2528 does not exist.
         //
         verifyException("pamvotis.core.Simulator", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0L, simulator0.getTime());
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertNotNull(simulator0);
      
      float float0 = simulator0.getSysThrPkts();
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0L, simulator0.getTime());
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertEquals(0.0F, float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0L, simulator0.getTime());
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertNotNull(simulator0);
      
      try { 
        simulator0.getJitter((-1139));
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Node -1139 does not exist.
         //
         verifyException("pamvotis.core.Simulator", e);
      }
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertEquals(0L, simulator0.getTime());
      assertNotNull(simulator0);
      
      // Undeclared exception!
      simulator0.simulate(1L, 1L);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertEquals(0L, simulator0.getTime());
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertNotNull(simulator0);
      
      SpecParams.RTS = 2083;
      try { 
        simulator0.getDelay((-990));
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Node -990 does not exist.
         //
         verifyException("pamvotis.core.Simulator", e);
      }
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      assertEquals(0L, simulator0.getTime());
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertNotNull(simulator0);
      
      try { 
        simulator0.getThrBps(1372);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Node 1372 does not exist.
         //
         verifyException("pamvotis.core.Simulator", e);
      }
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      assertEquals(0L, simulator0.getTime());
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertNotNull(simulator0);
      
      SpecParams.CW_MIN_OFDM = 9000000;
      int int0 = simulator0.getProgress();
      assertEquals(0L, simulator0.getTime());
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0, int0);
      
      simulator0.removeAllNodes();
      assertEquals(0L, simulator0.getTime());
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0, simulator0.getProgress());
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      assertEquals(0, simulator0.getProgress());
      assertEquals(0.0F, simulator0.getSysThrBps(), 0.01F);
      assertEquals(0.0F, simulator0.getSysThrPkts(), 0.01F);
      assertEquals(0.0F, simulator0.getSysUtil(), 0.01F);
      assertEquals(0L, simulator0.getTime());
      assertNotNull(simulator0);
      
      int int0 = 1131;
      try { 
        simulator0.getMDelay(1131);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Node 1131 does not exist.
         //
         verifyException("pamvotis.core.Simulator", e);
      }
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      simulator0.printMeanValues();
      // Undeclared exception!
      simulator0.simulate((-642L), 0L);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      // Undeclared exception!
      simulator0.simulate(0L, 1037L);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      SpecParams.RTS = 3319;
      try { 
        simulator0.removeNode(0);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Node 0 does not exist.
         //
         verifyException("pamvotis.core.Simulator", e);
      }
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      try { 
        simulator0.getThrPkts((-2852));
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Node -2852 does not exist.
         //
         verifyException("pamvotis.core.Simulator", e);
      }
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      int int0 = 1;
      SpecParams.MAC = 1;
      SpecParams.ACK = (-548);
      try { 
        simulator0.getQLength(1295);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Node 1295 does not exist.
         //
         verifyException("pamvotis.core.Simulator", e);
      }
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      int int0 = 54000000;
      int int1 = 0;
      int int2 = 192;
      try { 
        simulator0.getQDelay(109);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Node 109 does not exist.
         //
         verifyException("pamvotis.core.Simulator", e);
      }
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      int int0 = 101;
      long long0 = (-2652L);
      try { 
        simulator0.getQDelay((-1622));
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Node -1622 does not exist.
         //
         verifyException("pamvotis.core.Simulator", e);
      }
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      try { 
        simulator0.getUtil(101);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Node 101 does not exist.
         //
         verifyException("pamvotis.core.Simulator", e);
      }
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      SpecParams.ReadParameters();
      simulator0.confParams();
      long long0 = 0L;
      try { 
        simulator0.removeAllSources(67);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Node 67 does not exist.
         //
         verifyException("pamvotis.core.Simulator", e);
      }
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      // Undeclared exception!
      try { 
        simulator0.simulate((-1608L), (-1608L));
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("pamvotis.core.Simulator", e);
      }
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      SpecParams.LONG_PHY = (-2373.0F);
      simulator0.printMeanValues();
      long long0 = simulator0.getTime();
      assertEquals(0, simulator0.getProgress());
      assertEquals(0L, long0);
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      int int0 = 192;
      // Undeclared exception!
      try { 
        simulator0.changeNodeParams(192, 192, 192, 192);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // 192 >= 0
         //
         verifyException("java.util.Vector", e);
      }
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      int int0 = 144;
      int int1 = 109;
      int int2 = 0;
      // Undeclared exception!
      try { 
        simulator0.changeNodeParams(144, 109, 0, 0);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // 144 >= 0
         //
         verifyException("java.util.Vector", e);
      }
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      Simulator simulator0 = new Simulator();
      try { 
        simulator0.removeSource((-4375), (-4375));
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Node -4375 does not exist.
         //
         verifyException("pamvotis.core.Simulator", e);
      }
  }
}