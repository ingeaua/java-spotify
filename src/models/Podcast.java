package models;

import java.util.Objects;

public class Podcast
{
    private String podcastName;
    private String creator;
    private Integer duration;
    private String topic;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Podcast podcast = (Podcast) o;
        return Objects.equals(podcastName, podcast.podcastName) && Objects.equals(creator, podcast.creator) && Objects.equals(duration, podcast.duration) && Objects.equals(topic, podcast.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(podcastName, creator, duration, topic);
    }

    public Podcast(String podcastName, String creator, Integer duration, String topic) {
        this.podcastName = podcastName;
        this.creator = creator;
        this.duration = duration;
        this.topic = topic;
    }

    public String getPodcastName() {
        return podcastName;
    }

    public String getCreator() {
        return creator;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getTopic() {
        return topic;
    }
}