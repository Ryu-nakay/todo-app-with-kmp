//
//  TodoView.swift
//  iosApp
//
//  Created by cw-ryu.nakayama on 2023/08/29.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct TodoView: View {
    @StateObject var viewModel = TodoViewModel()

    var body: some View {
        VStack {
            HStack {
                TextField("内容を入力してください", text: $viewModel.inputContent)
                    .textFieldStyle(.roundedBorder)

                Button {
                    viewModel.onTapAddButton()
                } label: {
                    Text("追加")
                }
            }
            .padding()

            List {
                ForEach(0 ..< Int(viewModel.todoItemList.items.size), id: \.self) { index in
                    HStack {
                        Text("\(viewModel.todoItemList.items.get(index: Int32(index))?.name ?? "")")
                        Spacer()
                        Button {

                        } label: {
                            if(viewModel.todoItemList.items.get(index: Int32(index))?.state == TodoItem.State.todo) {
                                Image(systemName: "circle")
                            } else {
                                Image(systemName: "checkmark.circle")
                            }
                        }
                    }
                }
            }
        }
    }
}

struct TodoView_Previews: PreviewProvider {
    static var previews: some View {
        TodoView()
    }
}
