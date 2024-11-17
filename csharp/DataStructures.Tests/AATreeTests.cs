using System;
using System.Collections.Generic;
using System.Linq;
using DataStructures.AATree;
using FluentAssertions;
using NUnit.Framework;

namespace DataStructures.Tests;

internal class AaTreeTests
{
    [Test]
    public void Constructor_UseCustomComparer_FormsCorrectTree()
    {
        var tree = new AaTree<int>(Comparer<int>.Create((x, y) => y.CompareTo(x)));
        tree.AddRange(new[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        tree.GetMax().Should().Be(1);
        tree.GetMin().Should().Be(10);
        tree.GetKeysInOrder().SequenceEqual(new[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 }).Should().BeTrue();
        Validate(tree.Root);
    }

    [Test]
    public void Add_MultipleKeys_FormsCorrectTree()
    {
        var tree = new AaTree<int>();

        foreach (var elem in new[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 })
        {
            tree.Add(elem);
            tree.Count.Should().Be(elem);
            tree.Contains(elem).Should().BeTrue();
        }

        tree.GetKeysInOrder().SequenceEqual(new[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }).Should().BeTrue();
        tree.GetKeysPostOrder().SequenceEqual(new[] { 1, 3, 2, 5, 7, 10, 9, 8, 6, 4 }).Should().BeTrue();
        Validate(tree.Root);
    }

    [Test]
    public void Add_KeyAlreadyInTree_ThrowsException()
    {
        var tree = new AaTree<int>();
        tree.AddRange(new[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        Assert.Throws<ArgumentException>(() => tree.Add(1));
    }

    [Test]
    public void AddRange_MultipleKeys_FormsCorrectTree()
    {
        var tree = new AaTree<int>();
        tree.AddRange(new[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        tree.Count.Should().Be(10);
        tree.GetKeysInOrder().SequenceEqual(new[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }).Should().BeTrue();
        tree.GetKeysPostOrder().SequenceEqual(new[] { 1, 3, 2, 5, 7, 10, 9, 8, 6, 4 }).Should().BeTrue();
        Validate(tree.Root);
    }

    [Test]
    public void Remove_MultipleKeys_TreeStillValid()
    {
        var tree = new AaTree<int>();
        tree.AddRange(new[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });

        Remove(4).Should().NotThrow();
        tree.Contains(4).Should().BeFalse();
        tree.Count.Should().Be(9);

        Remove(8).Should().NotThrow();
        tree.Contains(8).Should().BeFalse();
        tree.Count.Should().Be(8);

        Remove(1).Should().NotThrow();
        tree.Contains(1).Should().BeFalse();
        tree.Count.Should().Be(7);

        Validate(tree.Root);

        Action Remove(int x) => () => tree.Remove(x);
    }

    [Test]
    public void Remove_KeyNotInTree_Throws()
    {
        var tree = new AaTree<int>();
        tree.AddRange(new[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });

        Action act = () => tree.Remove(999);
        act.Should().Throw<InvalidOperationException>();
    }

    [Test]
    public void Remove_EmptyTree_Throws()
    {
        var tree = new AaTree<int>();

        Action act = () => tree.Remove(999);
        act.Should().Throw<InvalidOperationException>();
    }

    [Test]
    public void Contains_NonEmptyTree_ReturnsCorrectAnswer()
    {
        var tree = new AaTree<int>();
        tree.AddRange(new[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        tree.Contains(6).Should().BeTrue();
        tree.Contains(999).Should().BeFalse();
    }

    [Test]
    public void Contains_EmptyTree_ReturnsFalse()
    {
        var tree = new AaTree<int>();
        tree.Contains(999).Should().BeFalse();
    }

    [Test]
    public void GetMax_NonEmptyTree_ReturnsCorrectAnswer()
    {
        var tree = new AaTree<int>();
        tree.AddRange(new[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        tree.GetMax().Should().Be(10);
    }

    [Test]
    public void GetMax_EmptyTree_ThrowsCorrectException()
    {
        var tree = new AaTree<int>();
        Assert.Throws<InvalidOperationException>(() => tree.GetMax());
    }

    [Test]
    public void GetMin_NonEmptyTree_ReturnsCorrectAnswer()
    {
        var tree = new AaTree<int>();
        tree.AddRange(new[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        tree.GetMin().Should().Be(1);
    }

    [Test]
    public void GetMin_EmptyTree_ThrowsCorrectException()
    {
        var tree = new AaTree<int>();
        Assert.Throws<InvalidOperationException>(() => tree.GetMin());
    }

    [Test]
    public void GetKeysInOrder_NonEmptyTree_ReturnsCorrectAnswer()
    {
        var tree = new AaTree<int>();
        tree.AddRange(new[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        tree.GetKeysInOrder().SequenceEqual(new[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }).Should().BeTrue();
    }

    [Test]
    public void GetKeysInOrder_EmptyTree_ReturnsCorrectAnswer()
    {
        var tree = new AaTree<int>();
        tree.GetKeysInOrder().ToList().Count.Should().Be(0);
    }

    [Test]
    public void GetKeysPreOrder_NonEmptyTree_ReturnsCorrectAnswer()
    {
        var tree = new AaTree<int>();
        tree.AddRange(new[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        tree.GetKeysPreOrder().SequenceEqual(new[] { 4, 2, 1, 3, 6, 5, 8, 7, 9, 10 })
            .Should().BeTrue();
    }

    [Test]
    public void GetKeysPreOrder_EmptyTree_ReturnsCorrectAnswer()
    {
        var tree = new AaTree<int>();
        tree.GetKeysPreOrder().ToList().Count.Should().Be(0);
    }

    [Test]
    public void GetKeysPostOrder_NonEmptyTree_ReturnsCorrectAnswer()
    {
        var tree = new AaTree<int>();
        tree.AddRange(new[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        tree.GetKeysPostOrder().SequenceEqual(new[] { 1, 3, 2, 5, 7, 10, 9, 8, 6, 4 })
            .Should().BeTrue();
    }

    [Test]
    public void GetKeysPostOrder_EmptyTree_ReturnsCorrectAnswer()
    {
        var tree = new AaTree<int>();
        tree.GetKeysPostOrder().ToList().Count.Should().Be(0);
    }

    private static bool Validate<T>(AaTreeNode<T>? node)
    {
        if (node is null)
        {
            return true;
        }

        var leafNodeCheck = CheckLeafNode(node);

        var leftCheck = CheckLeftSubtree(node);

        var rightCheck = CheckRightSubtree(node);

        var grandchildCheck = CheckRightGrandChild(node);

        var nonLeafChildrenCheck = CheckNonLeafChildren(node);

        var thisNodeResult = leafNodeCheck && leftCheck && rightCheck;
        thisNodeResult = thisNodeResult && grandchildCheck && nonLeafChildrenCheck;

        return thisNodeResult && Validate(node.Left) && Validate(node.Right);
    }

    private static bool CheckLeafNode<T>(AaTreeNode<T> node)
    {
        var condition = node.Left is null && node.Right is null && node.Level != 1;
        return !condition;
    }

    private static bool CheckLeftSubtree<T>(AaTreeNode<T> node)
    {
        var condition = node.Left is not null && node.Level - node.Left.Level != 1;
        return !condition;
    }

    private static bool CheckRightSubtree<T>(AaTreeNode<T> node)
    {
        var condition = node.Right is not null &&
                        node.Level - node.Right.Level != 1 &&
                        node.Level != node.Right.Level;
        return !condition;
    }

    private static bool CheckRightGrandChild<T>(AaTreeNode<T> node)
    {
        var condition = node.Right?.Right is not null && node.Right.Level < node.Right.Right.Level;
        return !condition;
    }

    private static bool CheckNonLeafChildren<T>(AaTreeNode<T> node)
    {
        var condition = node.Level > 1 && (node.Left is null || node.Right is null);
        return !condition;
    }
}
