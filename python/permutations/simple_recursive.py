class SimpleRecursive:
    def permutate(self, initial_list: list[int]) -> list[list[int]]:
        generated_permutations: list[list[int]] = []
        self.__simple_recursive_algo(
            generated_permutations=generated_permutations,
            current_permutation=[],
            elements_to_permute=initial_list,
        )
        return generated_permutations

    def __simple_recursive_algo(
        self,
        generated_permutations: list[list[int]],
        current_permutation: list[int],
        elements_to_permute: list[int],
    ):
        if len(elements_to_permute) == 0:
            generated_permutations.append(current_permutation)
        else:
            for element in elements_to_permute:
                next_permutation = current_permutation.copy()
                next_permutation.append(element)
                remaining_elements = elements_to_permute.copy()
                remaining_elements.remove(element)
                self.__simple_recursive_algo(
                    generated_permutations=generated_permutations,
                    current_permutation=next_permutation,
                    elements_to_permute=remaining_elements,
                )
