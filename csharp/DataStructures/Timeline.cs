using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;

namespace DataStructures;

public class Timeline<TValue> : ICollection<(DateTime Time, TValue Value)>, IEquatable<Timeline<TValue>>
{
    
    private readonly List<(DateTime Time, TValue Value)> timeline = new();

    public Timeline()
    {
    }

    public Timeline(DateTime time, TValue value)
        => timeline = new List<(DateTime, TValue)>
        {
            (time, value),
        };

    public Timeline(params (DateTime, TValue)[] timeline)
        => this.timeline = timeline
            .OrderBy(pair => pair.Item1)
            .ToList();

    public int TimesCount
        => GetAllTimes().Length;

    public int ValuesCount
        => GetAllValues().Length;

    public TValue[] this[DateTime time]
    {
        get => GetValuesByTime(time);
        set
        {
            var overridenEvents = timeline.Where(@event => @event.Time == time).ToList();
            foreach (var @event in overridenEvents)
            {
                timeline.Remove(@event);
            }

            foreach (var v in value)
            {
                Add(time, v);
            }
        }
    }

    bool ICollection<(DateTime Time, TValue Value)>.IsReadOnly
        => false;

    public int Count
        => timeline.Count;

    public void Clear()
        => timeline.Clear();

    public void CopyTo((DateTime, TValue)[] array, int arrayIndex)
        => timeline.CopyTo(array, arrayIndex);

    void ICollection<(DateTime Time, TValue Value)>.Add((DateTime Time, TValue Value) item)
        => Add(item.Time, item.Value);

    bool ICollection<(DateTime Time, TValue Value)>.Contains((DateTime Time, TValue Value) item)
        => Contains(item.Time, item.Value);

    bool ICollection<(DateTime Time, TValue Value)>.Remove((DateTime Time, TValue Value) item)
        => Remove(item.Time, item.Value);

    IEnumerator IEnumerable.GetEnumerator()
        => timeline.GetEnumerator();

    IEnumerator<(DateTime Time, TValue Value)> IEnumerable<(DateTime Time, TValue Value)>.GetEnumerator()
        => timeline.GetEnumerator();

    public bool Equals(Timeline<TValue>? other)
        => other is not null && this == other;

    public static bool operator ==(Timeline<TValue> left, Timeline<TValue> right)
    {
        var leftArray = left.ToArray();
        var rightArray = right.ToArray();

        if (left.Count != rightArray.Length)
        {
            return false;
        }

        for (var i = 0; i < leftArray.Length; i++)
        {
            if (leftArray[i].Time != rightArray[i].Time
                && !leftArray[i].Value!.Equals(rightArray[i].Value))
            {
                return false;
            }
        }

        return true;
    }

    public static bool operator !=(Timeline<TValue> left, Timeline<TValue> right)
        => !(left == right);

    public DateTime[] GetAllTimes()
        => timeline.Select(t => t.Time)
            .Distinct()
            .ToArray();

    public DateTime[] GetTimesByValue(TValue value)
        => timeline.Where(pair => pair.Value!.Equals(value))
            .Select(pair => pair.Time)
            .ToArray();

    public DateTime[] GetTimesBefore(DateTime time)
        => GetAllTimes()
            .Where(t => t < time)
            .OrderBy(t => t)
            .ToArray();

    public DateTime[] GetTimesAfter(DateTime time)
        => GetAllTimes()
            .Where(t => t > time)
            .OrderBy(t => t)
            .ToArray();

    public TValue[] GetAllValues()
        => timeline.Select(pair => pair.Value)
            .ToArray();

    public TValue[] GetValuesByTime(DateTime time)
        => timeline.Where(pair => pair.Time == time)
            .Select(pair => pair.Value)
            .ToArray();

    public Timeline<TValue> GetValuesBefore(DateTime time)
        => new(this.Where(pair => pair.Time < time).ToArray());

    public Timeline<TValue> GetValuesAfter(DateTime time)
        => new(this.Where(pair => pair.Time > time).ToArray());

    public Timeline<TValue> GetValuesByMillisecond(int millisecond)
        => new(timeline.Where(pair => pair.Time.Millisecond == millisecond).ToArray());

    public Timeline<TValue> GetValuesBySecond(int second)
        => new(timeline.Where(pair => pair.Time.Second == second).ToArray());

    public Timeline<TValue> GetValuesByMinute(int minute)
        => new(timeline.Where(pair => pair.Time.Minute == minute).ToArray());

    public Timeline<TValue> GetValuesByHour(int hour)
        => new(timeline.Where(pair => pair.Time.Hour == hour).ToArray());

    public Timeline<TValue> GetValuesByDay(int day)
        => new(timeline.Where(pair => pair.Time.Day == day).ToArray());

    public Timeline<TValue> GetValuesByTimeOfDay(TimeSpan timeOfDay)
        => new(timeline.Where(pair => pair.Time.TimeOfDay == timeOfDay).ToArray());

    public Timeline<TValue> GetValuesByDayOfWeek(DayOfWeek dayOfWeek)
        => new(timeline.Where(pair => pair.Time.DayOfWeek == dayOfWeek).ToArray());

    public Timeline<TValue> GetValuesByDayOfYear(int dayOfYear)
        => new(timeline.Where(pair => pair.Time.DayOfYear == dayOfYear).ToArray());

    public Timeline<TValue> GetValuesByMonth(int month)
        => new(timeline.Where(pair => pair.Time.Month == month).ToArray());

    public Timeline<TValue> GetValuesByYear(int year)
        => new(timeline.Where(pair => pair.Time.Year == year).ToArray());

    public void Add(DateTime time, TValue value)
    {
        timeline.Add((time, value));
    }

    public void Add(params (DateTime, TValue)[] timeline)
    {
        this.timeline.AddRange(timeline);
    }

    public void Add(Timeline<TValue> timeline)
        => Add(timeline.ToArray());

    public void AddNow(params TValue[] value)
    {
        var now = DateTime.Now;
        foreach (var v in value)
        {
            Add(now, v);
        }
    }

    public bool Contains(DateTime time, TValue value)
        => timeline.Contains((time, value));

    public bool Contains(params (DateTime, TValue)[] timeline)
        => timeline.Any(@event => Contains(@event.Item1, @event.Item2));

    public bool Contains(Timeline<TValue> timeline)
        => Contains(timeline.ToArray());

    public bool ContainsTime(params DateTime[] times)
    {
        var storedTimes = GetAllTimes();
        return times.Any(value => storedTimes.Contains(value));
    }

    public bool ContainsValue(params TValue[] values)
    {
        var storedValues = GetAllValues();
        return values.Any(value => storedValues.Contains(value));
    }

    public bool Remove(DateTime time, TValue value)
        => timeline.Remove((time, value));

    public bool Remove(params (DateTime, TValue)[] timeline)
    {
        var result = false;
        foreach (var (time, value) in timeline)
        {
            result |= this.timeline.Remove((time, value));
        }

        return result;
    }

    public bool Remove(Timeline<TValue> timeline)
        => Remove(timeline.ToArray());

    public bool RemoveTimes(params DateTime[] times)
    {
        var isTimeContainedInTheTimeline = times.Any(time => GetAllTimes().Contains(time));

        if (!isTimeContainedInTheTimeline)
        {
            return false;
        }

        var eventsToRemove = times.SelectMany(time =>
            timeline.Where(@event => @event.Time == time))
            .ToList();

        foreach (var @event in eventsToRemove)
        {
            timeline.Remove(@event);
        }

        return true;
    }

    public bool RemoveValues(params TValue[] values)
    {
        var isValueContainedInTheTimeline = values.Any(v => GetAllValues().Contains(v));

        if (!isValueContainedInTheTimeline)
        {
            return false;
        }

        var eventsToRemove = values.SelectMany(value =>
            timeline.Where(@event => EqualityComparer<TValue>.Default.Equals(@event.Value, value)))
            .ToList();

        foreach (var @event in eventsToRemove)
        {
            timeline.Remove(@event);
        }

        return true;
    }

    public (DateTime Time, TValue Value)[] ToArray()
        => timeline.ToArray();

    public IList<(DateTime Time, TValue Value)> ToList()
        => timeline;

    public IDictionary<DateTime, TValue> ToDictionary()
        => timeline.ToDictionary(@event => @event.Time, @event => @event.Value);

    public override bool Equals(object? obj)
        => obj is Timeline<TValue> otherTimeline
           && this == otherTimeline;

    public override int GetHashCode()
        => timeline.GetHashCode();
}
