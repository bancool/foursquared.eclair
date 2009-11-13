/**
 * Copyright 2009 Joe LaPenna
 */

package com.joelapenna.foursquare.parsers;

import com.joelapenna.foursquare.Foursquare;
import com.joelapenna.foursquare.error.FoursquareError;
import com.joelapenna.foursquare.error.FoursquareParseException;
import com.joelapenna.foursquare.types.Score;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Auto-generated: 2009-11-12 21:45:34.320698
 *
 * @author Joe LaPenna (joe@joelapenna.com)
 * @param <T>
 */
public class ScoreParser extends AbstractParser<Score> {
    private static final Logger LOG = Logger.getLogger("ScoreParser");
    private static final boolean DEBUG = Foursquare.PARSER_DEBUG;

    @Override
    public Score parseInner(XmlPullParser parser) throws XmlPullParserException, IOException,
            FoursquareError, FoursquareParseException {
        parser.require(XmlPullParser.START_TAG, null, null);

        Score score = new Score();

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            if (DEBUG) LOG.log(Level.FINE, "Tag Name: " + String.valueOf(parser.getName()));

            String name = parser.getName();
            if ("icon".equals(name)) {
                score.setIcon(parser.nextText());

            } else if ("message".equals(name)) {
                score.setMessage(parser.nextText());

            } else if ("points".equals(name)) {
                score.setPoints(parser.nextText());

            } else {
                // Consume something we don't understand.
                if (DEBUG) LOG.log(Level.FINE, "Found tag that we don't recognize: " + name);
                skipSubTree(parser);
            }
        }
        return score;
    }
}
