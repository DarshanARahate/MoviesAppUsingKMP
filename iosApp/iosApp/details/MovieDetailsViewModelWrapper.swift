

import Foundation
import Shared

class MovieDetailsViewModelWrapper: ObservableObject {
    
    var viewModel: MovieDetailsViewModel
    
    @Published var uiState: DetailsUiState = DetailsUiState.init(
        isLoading: false, error: "", data: nil)
    
    var task : Task<Void, Never>?
    
    init() {
        viewModel = ProvideViewModel.shared.getMovieDetailsViewModel()
        task = Task{@MainActor[weak self] in
            if (self != nil) {
                await collect(stateFlow: self!.viewModel.uiState,
                                          onEach: { value in self!.uiState = value })
            }
        }
    }
    
    deinit{
        task?.cancel()
    }
}





