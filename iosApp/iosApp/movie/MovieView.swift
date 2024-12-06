

import SwiftUI

struct MovieView: View {
    let movieViewModelWrapper = MovieViewModelWrapper()
    
    
    var body: some View {
        VStack {
            if (movieViewModelWrapper.uiState.isLoading) {
                ProgressView()
            }
            if (!movieViewModelWrapper.uiState.error.isEmpty) {
                Text(String(movieViewModelWrapper.uiState.error))
            }
            if (movieViewModelWrapper.uiState.data != []) {
                
            }
        }
    }
}

#Preview {
    MovieView()
}
