package pomonitor.util;

import java.util.ArrayList;
import java.util.List;

import pomonitor.entity.News;
import pomonitor.entity.NewsEntity;

/**
 * 
 * @author 市委
 * 
 */
public class NewsAndNewsEnriryTran {
	public static NewsEntity newsToNewsEntity(News news) {
		NewsEntity newsEntity = new NewsEntity();
		newsEntity.setId(news.getId());
		newsEntity.setTitle(news.getTitle());
		newsEntity.setUrl(news.getUrl());
		newsEntity.setContent(news.getContent());
		newsEntity.setWeb(news.getWeb());
		newsEntity.setTime(news.getTime());
		newsEntity.setAllContent(news.getAllContent());
		newsEntity.setContentPath(news.getContentPath());
		newsEntity.setFailedCount(news.getFailedCount());
		String key = news.getKeyWords();
		java.util.List<String> keyw = new ArrayList<String>();
		String[] keys = key.split("#");
		for (int j = 0; j < keys.length; j++) {
			if (keys[j].equals("#") || keys[j].equals(""))
				;
			else
				keyw.add(j, keys[j]);
		}
		// List<String> list = java.util.Arrays.asList(key);
		// for(int i=0;i<list.size();i++){
		System.out.println(keyw + "!!!!!");

		System.out.println(keyw.get(0) + "!!!!!");
		// }
		newsEntity.setKeywords(keyw);
		// newsEntity.setFinish(Interage.parse((news.getIsFinsh()));
		if (news.getIsFinsh() == 1) {

			newsEntity.setFinish(true);

		} else {
			newsEntity.setFinish(false);
		}
		if (news.getIsFailed() == 1) {
			newsEntity.setFailed(true);
		} else {
			newsEntity.setFailed(false);
		}
		if (news.getIsWorking() == 1) {
			newsEntity.setWorking(true);
		} else {
			newsEntity.setWorking(false);
		}
		return newsEntity;
	}

	public static News newsEntityToNews(NewsEntity newsentity) {
		News news = new News();
		news.setId(newsentity.getId());
		news.setTitle(newsentity.getTitle());
		news.setUrl(newsentity.getUrl());
		news.setContent(newsentity.getContent());
		news.setWeb(newsentity.getWeb());
		news.setTime(newsentity.getTime());
		news.setAllContent(newsentity.getAllContent());
		news.setContentPath(newsentity.getContentPath());
		news.setFailedCount(newsentity.getFailedCount());
		// 将newsentity中的list类型的 keywords转化为String类型
		String keyWords = "";
		for (String s : newsentity.getKeywords()) {
			keyWords += s + "#";
		}
		news.setKeyWords(keyWords);
		if (newsentity.isFinish() == true) {
			news.setIsFinsh(1);
		} else {
			news.setIsFinsh(0);
		}
		if (newsentity.isFailed() == true) {
			news.setIsFailed(1);
		} else {
			news.setIsFailed(0);
		}
		if (newsentity.isWorking() == true) {
			news.setIsWorking(1);
		} else {
			news.setIsWorking(0);
		}
		return news;

	}
}
