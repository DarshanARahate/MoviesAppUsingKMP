

//import SwiftUI
//
//struct MovieSearchView: View {
//    
//    @ObservedObject var movieViewModelWrapper = MovieViewModelWrapper()
//    
//    var body: some View {
//        NavigationView {
//            VStack {
//                if (movieViewModelWrapper.uiState.isLoading) { ProgressView()  }
//                if (!movieViewModelWrapper.uiState.error.isEmpty) {
//                    Text(String(movieViewModelWrapper.uiState.error))
//                }
//                if (movieViewModelWrapper.uiState.data != []) {
//                    List(movieViewModelWrapper.uiState.data ?? [], id : \.self) { item in
//                        VStack {
//                            AsyncImage(url: URL(string : item.poster),
//                                       content: { image in
//                                image.resizable().aspectRatio(contentMode: .fill)
//                                    .frame(width: .inifinity, height: 300)
//                                    .clipped()
//                            }, placeholder: {  ProgressView()  } )
//                            
//                            Text(item.title).font(.title)
//                                .fontWeight(.bold)
//                                .foregroundColor(.black)
//                            
//                        }.ignoresSafeArea().padding(.vertical, 8)
//                            .background(
//                                NavigationLink(destination: {
//                                    MovieDetailsView(imdbId: item.imdbID)
//                                }, label: {
//                                    
//                                }).opasity(0)
//                            )
//                            .listRowInsets(EdgeInsets())
//                        
//                    }.listStyle(PlainListStyle())
//                        .padding(0)//.searchable(text: $movieViewModelWrapper.queryText)
//                }
//            }
//        }.searchable(text: $movieViewModelWrapper.queryText)
//    }
//}


import SwiftUI

struct MovieSearchView: View {
    @ObservedObject var movieViewModelWrapper = MovieViewModelWrapper()
    
    var body: some View {
        NavigationView {
            VStack {
                // Loading state
                if movieViewModelWrapper.uiState.isLoading {
                    ProgressView()
                }
                
                // Error state
                if !movieViewModelWrapper.uiState.error.isEmpty {
                    Text(movieViewModelWrapper.uiState.error)
                        .foregroundColor(.red)
                        .multilineTextAlignment(.center)
                        .padding()
                }
                
                // Data state
                if let movies = movieViewModelWrapper.uiState.data, !movies.isEmpty {
                    List(movies, id: \.self) { item in
                        VStack(alignment: .leading) {
                            AsyncImage(url: URL(string: item.poster)) { image in
                                image
                                    .resizable()
                                    .aspectRatio(contentMode: .fill)
                                    .frame(width: .infinity, height: 300)
                                    .clipped()
                            } placeholder: {
                                ProgressView()
                            }

                            Text(item.title)
                                .font(.title)
                                .fontWeight(.bold)
                                .foregroundColor(.black)
                                .padding(.top, 8)

                        }
                        .padding(.vertical, 8)
                        .background(
                            NavigationLink(
                                destination: MovieDetailsView(imdbId: item.imdbID),
                                label: { EmptyView() }
                            ).opacity(0)
                        )
                        .listRowInsets(EdgeInsets())
                    }
                    .listStyle(PlainListStyle())
                }
            }
            .navigationTitle("Movies")
            .searchable(text: $movieViewModelWrapper.queryText)
        }
    }
}

