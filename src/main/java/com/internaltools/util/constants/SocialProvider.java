package com.internaltools.util.constants;

public enum SocialProvider {
	FACEBOOK("facebook"), GOOGLE("google"),LOCAL("local"),APPLE("apple");

	private String providerType;

	public String getProviderType() {
		return providerType;
	}

	SocialProvider(final String providerType) {
		this.providerType = providerType;
	}
}
