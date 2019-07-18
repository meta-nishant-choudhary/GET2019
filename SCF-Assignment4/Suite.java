package com.metacube;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(org.junit.runners.Suite.class)
@SuiteClasses({ FitXYPositiveTest.class,
				MaxClumpTest.class,
				MaxMirrorTest.class,
				SplitArrayTest.class})
public class Suite {

}
