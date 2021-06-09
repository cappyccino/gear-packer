require 'capybara/dsl'
require 'capybara/rspec'

Capybara.current_driver = :selenium_headless
Capybara.app_host = 'localhost:3000'
Capybara.run_server = false

feature "the first page" do
  it "has the right text" do
    visit '/'
    expect(page).to have_content 'Beep Boop I am a react app'
  end
end
