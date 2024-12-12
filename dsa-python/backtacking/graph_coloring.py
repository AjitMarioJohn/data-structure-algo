from typing import List


class UndirectedGraph:
    def __init__(self, size: int):
        self._adjacentList: List[set[int]] = [set() for _ in range(size)]


    def add_edge(self, v: int, w: int):
        """
        Adds an edge to the graph.

        :param v: One vertex of the edge
        :param w: The other vertex of the edge
        """
        self._adjacentList[v].add(w)
        self._adjacentList[w].add(v)

    def vertices(self) -> int:
        """
        Returns the number of vertices in the graph.

        :return: Number of vertices
        """
        return len(self._adjacentList)

    def get_adjacent(self, edge: int) -> set[int]:
        """
        Gets the adjacent vertices of the provided vertex.

        :param vertex: The vertex whose adjacents are needed
        :return: Set of adjacent vertices
        """
        return self._adjacentList[edge]



class GraphColoring:
    """
    Class for finding the number of combinations of colors that can be applied to vertices in the graph.
    """
    def __init__(self, undirected_graph: UndirectedGraph):
        # graph on which we have to apply color
        self._graph = undirected_graph
        # default color
        self._DEFAULT_COLOR: int = 0

    def fill(self, num_of_color: int) -> List[List[int]]:
        """
        Finds all combinations of colors that can be applied to the graph vertices following the rules.

        :param num_of_colors: Number of colors available
        :return: List of combinations of colors that can be applied to the graph
        """
        colors: List[int] = [self._DEFAULT_COLOR] * self._graph.vertices()
        combinations: List[List[int]] = []

        self._helper(0, num_of_color, colors, combinations)

        return combinations

    def _helper(self, vertex: int, num_of_colors: int, colors: List[int], combinations:List[List[int]]):
        """
        Recursive helper function to find color combinations.

        :param vertex: The current vertex to color
        :param num_of_colors: Number of available colors
        :param colors: List of colors assigned to vertices
        :param combinations: List to store all valid color combinations
        """
        if vertex == self._graph.vertices():
            combinations.append(list(colors))
            return

        for color in range(1, num_of_colors + 1):
            if self._can_color(vertex, color, colors):
                colors[vertex] = color
                self._helper(vertex + 1, num_of_colors, colors, combinations)
                colors[vertex] = self._DEFAULT_COLOR


    def _can_color(self, vertex: int, color: int, colors: List[int]) -> bool:
        """
        Checks if the vertex can be colored with the given color without violating the graph coloring constraints.

        :param vertex: The vertex to color
        :param color: The color to apply
        :param colors: List of colors assigned to vertices
        :return: True if the color can be applied, otherwise False
        """
        for adjacent in self._graph.get_adjacent(vertex):
            if colors[adjacent] == color:
                return False
        return True



if __name__ == "__main__":
    graph: UndirectedGraph = UndirectedGraph(4)
    graph.add_edge(0, 1)
    graph.add_edge(0, 3)
    graph.add_edge(1, 2)
    graph.add_edge(2, 3)
    print(GraphColoring(graph).fill(2))