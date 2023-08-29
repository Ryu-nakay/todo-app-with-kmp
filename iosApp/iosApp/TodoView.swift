//
//  TodoView.swift
//  iosApp
//
//  Created by cw-ryu.nakayama on 2023/08/29.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct TodoView: View {
    @StateObject var viewModel = TodoViewModel()

    var body: some View {
        List {
            ForEach(0 ..< Int(viewModel.todoItemList.items.size)) { index in
                Text("\(viewModel.todoItemList.items.get(index: Int32(index))?.name ?? "")")
            }
        }
    }
}

struct TodoView_Previews: PreviewProvider {
    static var previews: some View {
        TodoView()
    }
}
