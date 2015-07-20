package com.github.gnip.consumer.util

import org.scalatest.{ FlatSpec, Matchers }

/**
 * Created by jero on 14/07/15.
 */
class JsonUtilTest extends FlatSpec with Matchers {

  "JsonUtil" should "convert map to bson document" in {
    val tweet = """{"id":"tag:search.twitter.com,2005:403224522679009280","objectType":"activity","actor":{"objectType":"person","id":"id:twitter.com:1855784545","link":"http://www.twitter.com/LandenEhlers","displayName":"Landen Ehlers","postedTime":"2013-09-11T23:52:03.000Z","image":"https://pbs.twimg.com/profile_images/378800000646150423/83090ccb95a60def923c674e7bd002a0_normal.jpeg","summary":"Senior Construction Science student at Texas A&M University. Barefoot Waterskiing National Champion. Vice President of the Texas A&M Waterski Team.","links":[{"href":null,"rel":"me"}],"friendsCount":65,"followersCount":15,"listedCount":1,"statusesCount":24,"twitterTimeZone":null,"verified":false,"utcOffset":null,"preferredUsername":"LandenEhlers","languages":["en"],"location":{"objectType":"place","displayName":"College Station, TX"},"favoritesCount":2},"verb":"post","postedTime":"2013-11-20T18:13:12.000Z","generator":{"displayName":"Twitter for Android","link":"http://twitter.com/download/android"},"provider":{"objectType":"service","displayName":"Twitter","link":"http://www.twitter.com"},"link":"http://twitter.com/LandenEhlers/statuses/403224522679009280","body":"Enjoyed our half price chicken and wawfuls today! @tamusportclubs @SullysGrill @TAMUWaterski #SCPartnerday http://t.co/XRsVqYy9Zo","object":{"objectType":"note","id":"object:search.twitter.com,2005:403224522679009280","summary":"Enjoyed our half price chicken and wawfuls today! @tamusportclubs @SullysGrill @TAMUWaterski #SCPartnerday http://t.co/XRsVqYy9Zo","link":"http://twitter.com/LandenEhlers/statuses/403224522679009280","postedTime":"2013-11-20T18:13:12.000Z"},"favoritesCount":0,"location":{"objectType":"place","twitter_place_type":"city","displayName":"College Station, TX","name":"College Station","country_code":"United States","twitter_country_code":"US","link":"https://api.twitter.com/1.1/geo/id/85128f80a57c03ad.json","geo":{"type":"Polygon","coordinates":[[[-96.386719,30.534473],[-96.386719,30.658246],[-96.204688,30.658246],[-96.204688,30.534473]]]}},"geo":{"type":"Point","coordinates":[30.622496,-96.3283527]},"twitter_entities":{"hashtags":[{"text":"SCPartnerday","indices":[93,106]}],"symbols":[],"urls":[],"user_mentions":[{"screen_name":"tamusportclubs","name":"TAMU Sport Clubs","id":338528272,"id_str":"338528272","indices":[50,65]},{"screen_name":"SullysGrill","name":"Sully's Sports Grill","id":325152462,"id_str":"325152462","indices":[66,78]},{"screen_name":"TAMUWaterski","name":"TAMU Waterski","id":432729855,"id_str":"432729855","indices":[79,92]}],"media":[{"id":504756639421840000,"id_str":"504756639421837312","indices":[64,86],"media_url":"http://pbs.twimg.com/media/BwFBfT7CMAA-Jct.jpg","media_url_https":"https://pbs.twimg.com/media/BwFBfT7CMAA-Jct.jpg","url":"http://t.co/VPXUMLqPKI","display_url":"pic.twitter.com/VPXUMLqPKI","expanded_url":"http://twitter.com/RedSox/status/504756640550514688/photo/1","type":"photo","sizes":{"medium":{"w":600,"h":800,"resize":"fit"},"large":{"w":645,"h":860,"resize":"fit"},"thumb":{"w":150,"h":150,"resize":"crop"},"small":{"w":340,"h":453,"resize":"fit"}}}]},"twitter_extended_entities":{"media":[{"id":504756639421840000,"id_str":"504756639421837312","indices":[64,86],"media_url":"http://pbs.twimg.com/media/BwFBfT7CMAA-Jct.jpg","media_url_https":"https://pbs.twimg.com/media/BwFBfT7CMAA-Jct.jpg","url":"http://t.co/VPXUMLqPKI","display_url":"pic.twitter.com/VPXUMLqPKI","expanded_url":"http://twitter.com/RedSox/status/504756640550514688/photo/1","type":"photo","sizes":{"medium":{"w":600,"h":800,"resize":"fit"},"large":{"w":645,"h":860,"resize":"fit"},"thumb":{"w":150,"h":150,"resize":"crop"},"small":{"w":340,"h":453,"resize":"fit"}}},{"id":504756639421850000,"id_str":"504756639421853696","indices":[64,86],"media_url":"http://pbs.twimg.com/media/BwFBfT7CcAAYBhR.jpg","media_url_https":"https://pbs.twimg.com/media/BwFBfT7CcAAYBhR.jpg","url":"http://t.co/VPXUMLqPKI","display_url":"pic.twitter.com/VPXUMLqPKI","expanded_url":"http://twitter.com/RedSox/status/504756640550514688/photo/1","type":"photo","sizes":{"large":{"w":773,"h":579,"resize":"fit"},"medium":{"w":600,"h":449,"resize":"fit"},"thumb":{"w":150,"h":150,"resize":"crop"},"small":{"w":340,"h":254,"resize":"fit"}}}]},"twitter_filter_level":"medium","twitter_lang":"en","retweetCount":0,"gnip":{"matching_rules":[{"value":"has:geo has:mentions has:links has:hashtags has:profile_geo","tag":null}],"urls":[{"url":"http://t.co/XRsVqYy9Zo","expanded_url":"http://twitter.com/LandenEhlers/status/403224522679009280/photo/1","expanded_status":200}],"klout_score":21,"klout_profile":{"topics":[{"klout_topic_id":"10000000000000010000","displayName":"Ricky Carmichael","link":"http://klout.com/topic/id/10000000000000010000"},{"klout_topic_id":"1297","displayName":"Rock Music","link":"http://klout.com/topic/id/1297"}],"klout_user_id":"289637767579957066","link":"http://klout.com/user/id/289637767579957066"},"language":{"value":"en"},"profileLocations":[{"objectType":"place","geo":{"type":"point","coordinates":[-96.33441,30.62798]},"address":{"country":"United States","countryCode":"US","locality":"College Station","region":"Texas","subRegion":"Brazos County"},"displayName":"College Station, Texas, United States"}]}}"""
    val mapFromTweetJson = JsonUtil.fromJson(tweet)
    val bsonDoc = JsonUtil.toBson(mapFromTweetJson)
    val mapFromBson = JsonUtil.fromJson(bsonDoc.toJson())
    mapFromBson shouldBe mapFromTweetJson
  }
}
