package com.tangorabox.resumefx.util;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;

public enum Section {

    BASIC_INFO("About", FontAwesomeIcon.HOME, false),
    WORK("Work Experience", FontAwesomeIcon.BUILDING, true),
    VOLUNTEER("Volunteer", FontAwesomeIcon.HANDSHAKE_ALT, true),
    EDUCATION("Education", FontAwesomeIcon.GRADUATION_CAP, true),
    AWARD("Awards", FontAwesomeIcon.TROPHY, true),
    PUBLICATION("Publications", FontAwesomeIcon.BOOK, true),
    SKILL("Skills", FontAwesomeIcon.CODE, false),
    LANGUAGE("Languages", FontAwesomeIcon.LANGUAGE, false),
    INTEREST("Interests", FontAwesomeIcon.HEART, false),
    REFERENCE("References", FontAwesomeIcon.THUMBS_UP, false);

    private final String text;
    private final boolean hasPeriod;
    private final FontAwesomeIcon icon;

    Section(String text, FontAwesomeIcon icon, boolean hasPeriod) {
        this.text = text;
        this.icon = icon;
        this.hasPeriod = hasPeriod;
    }

    public boolean hasPeriod() {
        return hasPeriod;
    }

    public FontAwesomeIcon getIcon() {
        return icon;
    }

    @Override
    public String toString() {
        return text;
    }
}
