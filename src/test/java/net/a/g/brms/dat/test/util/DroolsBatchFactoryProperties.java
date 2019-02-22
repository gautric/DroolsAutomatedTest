package net.a.g.brms.dat.test.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class DroolsBatchFactoryProperties {
	private static final String BUNDLE_NAME = "character-unit-test"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	public static final String CHARACTER_UNIT_TEST_SHEET = "character-unit-test.sheet"; //$NON-NLS-1$

	public static final String CHARACTER_UNIT_TEST_FILE_NAME = "character-unit-test.file-name"; //$NON-NLS-1$

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
