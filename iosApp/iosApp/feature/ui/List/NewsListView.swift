//
//  NewsListView.swift
//  News App
//
//  Created by Wildan Nafian on 9/21/24.
//

import SwiftUI
//import CoreData
import shared

struct NewsListView: View {

    @StateObject var vm = NewsViewModel()
//    @StateObject var bookmarkViewModel = BookmarkViewModel()

//    @Environment(\.managedObjectContext) var viewContext

    @State private var selectedNews: NewsItem? = nil
    @State private var hasFetched = false
    @State private var isSheetDisplayed = false

    var body: some View {
    
        NavigationStack {
            ZStack {
                ScrollView {
                    LazyVStack {
                        ForEach(vm.newsData.indices, id: \.self) { index in
                            NavigationLink(destination: DetailView(newsData: vm.newsData[index])) {
                                NewsItemCard(
                                    item: vm.newsData[index],
                                    onTapBookmark: {
//                                        updateBookmarkStatus(index: index)
                                    },
                                    selectedNews: $selectedNews,
                                    isSheetDisplayed: $isSheetDisplayed
                                )
                            }
                            .buttonStyle(PlainButtonStyle())
                        }
                    }
                }.refreshable {
                    Task {
                        await vm.getNewsData()
                    }
                }
                .sheet(isPresented: Binding(
                    get: { isSheetDisplayed },
                    set: { isSheetDisplayed = $0 }
                )) {
                    if let selectedNews = selectedNews {
                        NewsDetailSheet(newsData: selectedNews)
                            .presentationDetents([.medium, .large])
                    }
                }
                .alert(isPresented: $vm.isAlertDisplayed, content: {
                    Alert(
                        title: Text(LocalizedStringKey("ErrorTitle")),
                        message: Text(vm.onError ?? ""),
                        dismissButton: .default(Text(LocalizedStringKey("GotIt")))
                    )
                })
//                .alert(isPresented: $viewModel.isFirstLaunch, content: {
//                    Alert(
//                        title: Text(LocalizedStringKey("WelcomeTitle")),
//                        message: Text(LocalizedStringKey("WelcomeContent")),
//                        dismissButton: .default(Text(LocalizedStringKey("GotIt"))) {
//                            viewModel.setIsNotFirstLaunch()
//                        }
//                    )
//                })
                if vm.isLoading {
                    ProgressView()
                        .scaleEffect(2)
                }
            }
            .navigationTitle("News App")
            .toolbar {
//                NavigationLink(destination: BookmarkView()) {
//                    Image(systemName: "bookmark.fill")
//                        .foregroundColor(.blue)
//                        .frame(width: 24, height: 24, alignment: .trailing)
//                }
            }
            .onAppear{
                if !hasFetched {
                    //                viewModel.checkIsFirstLaunch()
                    Task {
                        await vm.getNewsData()
                    }
                    hasFetched = true
                }
            }
        }
    }

//    private func updateBookmarkStatus(index: Int) {
//        let updatedNews = viewModel.toggleBookmark(index: index)
//        if(updatedNews.isBookmark) {
//            bookmarkViewModel.bookmarkNews(news: updatedNews, viewContext: viewContext)
//        } else {
//            bookmarkViewModel.deleteBookmark(title: updatedNews.title, viewContext: viewContext)
//        }
//    }
}

#Preview {
    NewsListView()
}
