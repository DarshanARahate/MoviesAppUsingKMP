

import SwiftUI

struct MovieDetailsView: View {
    let imdbId: String
    
    @ObservedObject var movieDetailsViewModel =
    MovieDetailsViewModelWrapper()
    
    var body: some View {
        ZStack {
            if (movieDetailsViewModel.uiState.isLoading) {
                ProgressView()
            }
            if (!movieDetailsViewModel.uiState.error.isEmpty) {
                Text(movieDetailsViewModel.uiState.error)
            }
            if (movieDetailsViewModel.uiState.data != nil) {
                ScrollView(content: {
                    VStack {
                        AsyncImage(
                            url: URL(string: movieDetailsViewModel.uiState.data!.poster),
                            content: {
                                image in image.resizable()
                                    .aspectRatio(contentMode: .fill)
                            },
                            placeholder: { ProgressView() }
                        )
                    }
                    
                    VStack(
                        alignment: .leading,
                        content: {
                            Text(movieDetailsViewModel.uiState.data!.title)
                                .font(.title)
                                .fontWeight(.bold)
                                .foregroundStyle(.black)
                            
                            Spacer(minLength: 12)
                            
                            Text("Plot" + movieDetailsViewModel.uiState.data!.plot)
                                .font(.title2)
                                .fontWeight(.bold)
                                .foregroundStyle(.black)
                            
                            Spacer(minLength: 12)
                            
                            Text("Language" + movieDetailsViewModel.uiState.data!.language)
                                .font(.title)
                                .fontWeight(.bold)
                                .foregroundStyle(.black)
                            
                            Spacer(minLength: 12)
                            
                            Text("Genre : " + movieDetailsViewModel.uiState.data!.genre)
                                .font(.title)
                                .fontWeight(.bold)
                                .foregroundStyle(.black)
                            
                            Spacer(minLength: 12)
                        }
                    ).padding(.horizontal, 16)
                }).ignoresSafeArea()
            }
        }.onAppear(perform: {
            movieDetailsViewModel.viewModel.getMovieDetails(imdbId: imdbId)
        })
    }
}

#Preview {
//    MovieDetailsView(imdbId = "")
}
