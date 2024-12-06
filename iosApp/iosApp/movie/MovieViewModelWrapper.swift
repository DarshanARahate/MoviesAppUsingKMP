
import Foundation
import Shared


class MovieViewModelWrapper : ObservableObject {
    var viewModel: MovieViewModel
    
    @Published var uiState: UiState = UiState.init(
        isLoading: false, error: "", data: [])
    
    @Published var queryText: String = "" {
        didSet {
            viewModel.updateQuery(search: queryText)
        }
    }
    
    var task : Task<Void, Never>?
    
    
    init() {
        viewModel = ProvideViewModel.shared.getMovieViewModel()
        task = Task{ @MainActor [weak self] in
            await collect(stateFlow: self!.viewModel.uiState as! CommonStateFlow<UiState>,
                  onEach: { value in self!.uiState = value  })
            
        }
    }
    
    deinit {
        task?.cancel()
    }
}
